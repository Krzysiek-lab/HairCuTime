package com.example.haircuttime.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Services {
    @Id

    private Long services_id;
    private String description;
    private BigDecimal price;
    private Long serviceDuration;
   // private Target targetCustomer;
}
