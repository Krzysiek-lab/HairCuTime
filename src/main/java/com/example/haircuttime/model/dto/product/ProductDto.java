package com.example.haircuttime.model.dto.product;


import com.example.haircuttime.model.entity.Appointment;
import com.example.haircuttime.model.entity.Barber;
import com.example.haircuttime.model.entity.Comment;
import com.example.haircuttime.model.enums.Target;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class ProductDto {
    @NotEmpty(message = "filed can not be empty")
    private String productName;
    @NotEmpty(message = "filed can not be empty")
    private String description;
    @NotEmpty(message = "filed can not be empty")
    private BigDecimal price;
    @NotEmpty(message = "filed can not be empty")
    private Long serviceDuration;

    //lista rozwijana
    Target targetCustomer;

    List<Barber> barbers;

    List<Comment> comments;

    List<Appointment> appointments;
}
