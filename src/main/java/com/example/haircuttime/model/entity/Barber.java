package com.example.haircuttime.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    @OneToMany(mappedBy = "barberId")
    private List<Absence> absences;
    @OneToMany(mappedBy = "barberId")
    private List<Availability> availabilityList;
    @OneToMany(mappedBy = "barberId", orphanRemoval = true)
    private List<WorkYear> workYears;
    @OneToMany(mappedBy = "barberId")
    private List<WorkWeek> workWeeks;
    @OneToMany(mappedBy = "barberId")
    private List<WorkDay> workDays;

}
