package com.example.haircuttime.model.dto.appointment;

import com.example.haircuttime.model.dto.product.ProductDto;
import com.example.haircuttime.model.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AppointmentDto {

    private Long id;
    @DateTimeFormat
    private LocalDate from;

    @NotNull
    private UserDto user;

    @DateTimeFormat
    private LocalDate to;

    private ProductDto product;
}
