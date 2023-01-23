package com.example.haircuttime.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="roles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private RoleName roleName;

}
