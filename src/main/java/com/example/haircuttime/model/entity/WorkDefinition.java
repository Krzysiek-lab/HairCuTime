package com.example.haircuttime.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Duration;
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
    @Column(name = "work_duration")
    private Duration workDuration;
    @OneToMany(mappedBy = "workDefinition")
    private List<WorkDay> workDay;
}

