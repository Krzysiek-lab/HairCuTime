package com.example.haircuttime.model.entity;

import com.example.haircuttime.model.enums.Gender;
import com.example.haircuttime.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "barbers")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Barber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Gender gender;

    @ManyToMany
    private List<Product> products;
    @OneToMany(mappedBy = "barber", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<WorkYear> workYears;


}