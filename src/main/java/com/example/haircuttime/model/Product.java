package com.example.haircuttime.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;
    private String productName;
    private String description;
    private BigDecimal price;
    private Long serviceDuration;
    Target targetCustomer;
    @ManyToMany(mappedBy = "products")
    List<Barber> barbers;

    @ManyToOne(mappedBy = "products")
    List<Comment> comments;

    @OneToMany(mappedBy = "product")
    List<Appointment> appointments;
}
