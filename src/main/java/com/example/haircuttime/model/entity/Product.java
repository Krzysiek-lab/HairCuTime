package com.example.haircuttime.model.entity;


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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="product_id")
    private Long productId;
    
    @Column(name="product_name")
    private String productName;
    
    private String description;
    private BigDecimal price;
    
    @Column(name="product_duration")
    private Long serviceDuration;
    
    @Column(name="target_cutsomer")
    Target targetCustomer;
    
    @ManyToMany(mappedBy = "products")
    List<Barber> barbers;

    @ManyToMany(mappedBy = "products")
    List<Comment> comments;

    @OneToMany(mappedBy = "product")
    List<Appointment> appointments;
}
