package com.example.haircuttime.model.entity;

import com.example.haircuttime.model.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "barbers")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Barber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany
    List<Product> products;
    @OneToMany(mappedBy = "barber")
    private List<Absence> absences;
    @OneToMany(mappedBy = "barber")
    private List<Availability> availabilities;


    @OneToMany(mappedBy = "barber", orphanRemoval = true)
    private List<WorkYear> workYears;

}
