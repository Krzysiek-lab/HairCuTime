package com.example.haircuttime.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.haircuttime.model.enums.Gender;
import com.example.haircuttime.model.enums.Role;

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
    private Gender gender;
    private Role role;
    
//    @ManyToOne
//    List<Comment> comments;

    @ManyToMany
    private List<Product> products;
    @OneToMany(mappedBy = "barber", cascade = CascadeType.ALL)
    private List<Absence> absences;
    @OneToMany(mappedBy = "barber", cascade = CascadeType.ALL)
    private List<Availability> availabilityList;
    @OneToMany(mappedBy = "barber", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<WorkYear> workYears;
    @OneToMany(mappedBy = "barber", cascade = CascadeType.ALL)
    private List<WorkWeek> workWeeks;
    @OneToMany(mappedBy = "barber", cascade = CascadeType.ALL)
    private List<WorkDay> workDays;
}
