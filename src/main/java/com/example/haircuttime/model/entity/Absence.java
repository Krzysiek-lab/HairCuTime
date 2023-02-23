package com.example.haircuttime.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
@Entity
@Table(name = "absences")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Barber barber;

    @ManyToOne(fetch = FetchType.LAZY)
    private WorkDay workDay;


    @Column(name = "absence_start")
    private LocalTime absenceStart;


    @Column(name = "absence_end")
    private LocalTime absenceEnd;
}
