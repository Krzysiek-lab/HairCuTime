package com.example.haircuttime.model.entity;

import com.example.haircuttime.model.enums.Role;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private Role name;

}
