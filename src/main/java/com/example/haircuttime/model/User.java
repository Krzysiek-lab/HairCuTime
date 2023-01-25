package com.example.haircuttime.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class User {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "names")
    private String name;

    @Column(name = "usernames")
    private String surname;

    @Column(unique = true)
    private String login;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private Long phoneNumber;

    @ManyToMany(mappedBy = "users")
    private List<Role_Entity> roles;

    @OneToMany
    private List<Appointment> appointments;
}
