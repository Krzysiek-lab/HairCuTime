package com.example.haircuttime.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder

public class Appointment {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;



    @Column
    private Long serviceLength;

    @ManyToOne
    private Product product;
}
