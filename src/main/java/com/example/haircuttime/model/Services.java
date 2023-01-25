package com.example.haircuttime.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long services_id;
    private String serviceName;
    private String description;
    private BigDecimal price;
    private Long serviceDuration;
    Target targetCustomer;
    @ManyToMany(mappedBy = "services")
    List<Barbers> barbers;

    @ManyToOne(mappedBy = "services")
    List<Comment> comments;

    @OneToMany(mappedBy = "service")
    List<Appointment> appointments;
}
