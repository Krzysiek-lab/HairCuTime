package com.example.haircuttime.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table(name = "availabilities")
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private WorkDay workDay;

    @ManyToOne
    private Barber barber;

    @Column(name = "start_time")
    private LocalTime startTime;


    @Column(name = "end_time")
    private LocalTime endTime;
}
