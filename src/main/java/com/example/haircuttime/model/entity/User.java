package com.example.haircuttime.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(unique = true,name="login")
    private String login;
    @Column(name="password")
    private String password;
    @Column(unique = true,name="email")
    private String email;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="roles")
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<RoleEntity> roles;
   // @OneToMany(mappedBy = "user")
   // private List<Appointment> appointments;

}

