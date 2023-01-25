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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nme="product_id")
    private Long productId;
    
    @Column(nme="product_name")
    private String productName;
    
    private String description;
    private BigDecimal price;
    
    @Column(nme="product_duration")
    private Long serviceDuration;
    
    @Column(nme="target_cutsomer")
    Target targetCustomer;
    
    @ManyToMany(mappedBy = "products")
    List<Barber> barbers;

    @ManyToOne(mappedBy = "products")
    List<Comment> comments;

    @OneToMany(mappedBy = "product")
    List<Appointment> appointments;
}
