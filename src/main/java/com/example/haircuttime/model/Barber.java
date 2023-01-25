package com.example.haircuttime.model;

import com.example.haircuttime.model.enums.Gender;
import com.example.haircuttime.model.enums.Role;
import lombok.*;

import javax.persistence.*;
import javax.xml.stream.events.Comment;
import java.util.List;

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
    @ManyToOne
    List<Comment> comments;
    @ManyToMany
    @JoinTable(name = "product_id")
    List<Product> products;
    @ManyToMany
    List<WorkYear> availability;
}
