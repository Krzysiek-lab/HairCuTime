package com.example.haircuttime.model.entity;

import com.example.haircuttime.model.enums.Gender;
import com.example.haircuttime.model.enums.Role;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
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
    private Role role;

//    @ManyToOne
//    List<Comment> comments;

    @ManyToMany
    List<Product> products;
    @OneToMany(mappedBy = "barber")
    private List<Absence> absences;
    @OneToMany(mappedBy = "barber")
    private List<Availability> availabilityList;
    @OneToMany(mappedBy = "barber", orphanRemoval = true)
    private List<WorkYear> workYears;
}
