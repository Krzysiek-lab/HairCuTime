package com.example.haircuttime.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Entity
@Builder
@Table(name = "work_definiton")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WorkDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalTime start;
    private LocalTime end;
    @Column(name = "work_duration")
    private Duration workDuration;
}

