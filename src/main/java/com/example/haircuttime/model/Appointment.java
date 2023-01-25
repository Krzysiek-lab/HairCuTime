package com.example.haircuttime.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class Appointment {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User userId;

    @Column
    private LocalDate from;

    @Column
    private LocalDate to;

    @ManyToOne
    private Product product;
}
