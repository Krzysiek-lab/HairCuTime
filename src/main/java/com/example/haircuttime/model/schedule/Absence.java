package com.example.haircuttime.model.schedule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @Column(name = "barber_id")
    private Long barberId;

    @NotNull
    @Column(name = "absence_start")
    private LocalTime absenceStart;

    @NotNull
    @Column(name = "absence_end")
    private LocalTime absenceEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_day_id")
    private WorkDay workDay;
}
