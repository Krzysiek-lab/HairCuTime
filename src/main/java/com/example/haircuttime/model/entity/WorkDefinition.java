package com.example.haircuttime.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "work_definition")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WorkDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalTime start;
    private LocalTime end;
    @OneToMany(mappedBy = "workDefinition")
    private List<WorkDay> workDay;
}

