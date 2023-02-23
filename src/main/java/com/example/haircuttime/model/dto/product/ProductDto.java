package com.example.haircuttime.model.dto.product;


import com.example.haircuttime.model.entity.Appointment;
import com.example.haircuttime.model.entity.Barber;
import com.example.haircuttime.model.entity.Comment;
import com.example.haircuttime.model.enums.Target;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class ProductDto {

    private Long id;
    @NotEmpty(message = "filed can not be empty")
    private String productName;
    @NotEmpty(message = "filed can not be empty")
    private String description;
    @DecimalMax("1000.00")// jaka najwyzsza cena
    @DecimalMin("10.00")// jaka najwyzsza cena
    private BigDecimal price;
    @NotNull
    private Long serviceDuration;
    Target targetCustomer;

    List<Barber> barbers;

    List<Comment> comments;

    List<Appointment> appointments;
}
