package com.example.haircuttime.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "work_day")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "day_in_year")
    private Long dayInYear;

    @JsonBackReference
    @ManyToOne
    private WorkYear workYear;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "work_definition_id", referencedColumnName = "id")
    private WorkDefinition workDefinition;
    @OneToMany(mappedBy = "id", cascade = CascadeType.PERSIST)
    private List<Availability> availabilities;
    @OneToMany(mappedBy = "id", cascade = CascadeType.PERSIST)
    private List<Absence> absences;
}

