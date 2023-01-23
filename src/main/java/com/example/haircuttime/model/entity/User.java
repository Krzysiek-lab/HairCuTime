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
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String surname;

    private String login;

    private String password;

    private String email;

    private String phoneNumber;

    private List<Role> roles;

}
enum RoleName{
    ADMIN,
    USER,
    PERSONNEL
}
