package com.example.haircuttime.model;

import com.example.haircuttime.model.enums.Target;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Services {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column
    private String serviceName;

    @Column
    private String description;

    @Column
    private BigDecimal price;

    @Column
    private Long serviceDuration;

    @Column
    private Target targetCustomer;

    @OneToMany(mappedBy = "services")
    private List<Appointment> appointments;
}
