package com.example.haircuttime.model.entity;


import com.example.haircuttime.model.enums.Target;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "products")
@Getter
@Setter
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long productId;
    
    @Column(name="product_name")
    private String productName;
    
    private String description;
    private BigDecimal price;
    
    @Column(name="product_duration")
    private Long productDuration;
    @Enumerated(EnumType.STRING)
    @Column(name="target_customer")
    Target targetCustomer;
    
    @ManyToMany(mappedBy = "products")
    List<Barber> barbers;

    @OneToMany(mappedBy = "product")
    List<Appointment> appointments;
}
