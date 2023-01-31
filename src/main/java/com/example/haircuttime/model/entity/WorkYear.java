package com.example.haircuttime.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "work_years")
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class WorkYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull
    private Long year;
    @NotNull
    @Column(name = "barber_id")
    private Long barberId;

    @OneToMany(mappedBy = "workYear", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<WorkDay> workDayList;
}
