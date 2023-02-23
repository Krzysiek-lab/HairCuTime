package com.example.haircuttime.model.dto.appointment;

import com.example.haircuttime.model.dto.product.ProductDto;
import com.example.haircuttime.model.dto.user.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AppointmentDto {

    private Long id;

    private LocalDate date;

    private LocalTime time;

    @NotNull
    @JsonIgnore
    private UserDto user;

    @NotNull
    private Long serviceLength;

    @NotNull
    private ProductDto product;
}
