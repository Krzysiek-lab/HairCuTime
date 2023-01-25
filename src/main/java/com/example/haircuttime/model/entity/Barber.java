package com.example.haircuttime.model.entity;

import com.example.haircuttime.model.enums.Gender;
import com.example.haircuttime.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
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
    //    @ManyToOne
//    List<Comment> comments;
    @ManyToMany
    @JoinTable(name = "product_id")
    List<Product> products;
//    @ManyToMany
//    List<WorkYear> availability;
}
