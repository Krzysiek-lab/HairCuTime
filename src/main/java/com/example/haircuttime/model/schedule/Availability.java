package com.example.haircuttime.model.schedule;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table (name = "availability")
@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "work_day_id")
    private WorkDay workDay;

    @Column(name = "barber_id")
    private Long barberId;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

}
