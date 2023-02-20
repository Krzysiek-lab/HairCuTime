package com.example.haircuttime.model.entity;

import jakarta.persistence.*;
import lombok.*;


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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long year;
    @ManyToOne
    private Barber barber;
    @OneToMany(mappedBy = "workYear", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<WorkDay> workDayList;
}
