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
    @ManyToMany(mappedBy = "services")
    List<Barber> barbers;

    @ManyToOne(mappedBy = "services")
    List<Comment> comments;

    @ManyToMany(mappedBy = "service")
    List<Appointment> appointments;
    // private Target targetCustomer;
}
