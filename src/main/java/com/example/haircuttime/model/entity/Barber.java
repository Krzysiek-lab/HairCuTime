package com.example.haircuttime.model.entity;

import com.example.haircuttime.model.enums.Gender;
import com.example.haircuttime.model.enums.Role;
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
    private Gender gender;

    @ManyToMany
    private List<Product> products;
    @OneToMany(mappedBy = "barberId", cascade = CascadeType.ALL)
    private List<WorkYear> workYears;
}