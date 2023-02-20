package com.example.haircuttime.model.entity;


import jakarta.persistence.*;
import lombok.*;


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
    @JoinColumn(name = "work_day_id")
    private WorkDay workDay;

    @ManyToOne
    @JoinColumn(name = "barber_id")
    private Barber barber;



    @Column(name = "start_time")
    private LocalTime startTime;


    @Column(name = "end_time")
    private LocalTime endTime;
}
