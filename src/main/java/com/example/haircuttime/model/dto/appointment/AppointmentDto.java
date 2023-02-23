package com.example.haircuttime.model.dto.appointment;

import com.example.haircuttime.model.dto.product.ProductDto;
import com.example.haircuttime.model.dto.user.UserDto;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AppointmentDto {

    private Long id;

    @NotNull
    private UserDto user;

    @NotNull
    private Long serviceLength;

    @NotNull
    private ProductDto product;
}
