package com.example.haircuttime.model.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Entity
@Table(name = "availability")
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
    @NotNull
    @JoinColumn(name = "work_day_id")
    private WorkDay workDay;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "barber_id")
    private Barber barber;

    @NotNull
    @Column(name = "start_time")
    private LocalTime startTime;

    @NotNull
    @Column(name = "end_time")
    private LocalTime endTime;
}
