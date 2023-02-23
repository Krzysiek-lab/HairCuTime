package com.example.haircuttime.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private LocalDate date;
    private LocalTime time;

    private Long serviceLength;

    @ManyToOne
    private Product product;
}
