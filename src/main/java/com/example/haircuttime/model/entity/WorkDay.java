package com.example.haircuttime.model.entity;


import com.example.haircuttime.model.enums.WorkDefinition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Embeddable
@Getter
@Table(name = "work_day")
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class WorkDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    @NotNull
    private WorkDefinition workDefinition;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "work_day_id")
    private List<Availability> availabilities = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "work_day_id")
    private List<Absence> absences = new ArrayList<>();
}

