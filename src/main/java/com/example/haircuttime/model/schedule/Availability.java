package com.example.haircuttime.model.schedule;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Entity
@Table(name = "availability")
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
    @NotNull
    @JoinColumn(name = "work_day_id")
    private WorkDay workDay;

    @NotNull
    @Column(name = "barber_id")
    private Long barberId;

    @NotNull
    @Column(name = "start_time")
    private LocalTime startTime;

    @NotNull
    @Column(name = "end_time")
    private LocalTime endTime;
}
