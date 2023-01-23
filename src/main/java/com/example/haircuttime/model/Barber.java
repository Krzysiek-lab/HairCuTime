package com.example.haircuttime.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
//@Table(name = "barbers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Barber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private Gender gender;
    private Role role;
    @ManyToMany
    @JoinColumn(name = "services_id")
    List<Services> services;
    @ManyToMany
    Map<Long, Services> barberServices;
  //  Map<Long,Week> availability;
}
