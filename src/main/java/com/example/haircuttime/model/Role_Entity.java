package com.example.haircuttime.model;

import com.example.haircuttime.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Role_Entity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Role role;

    @ManyToMany
    private List<User> users;
}
