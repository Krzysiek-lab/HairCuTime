package com.example.haircuttime.model.dto.appointment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CreateAppointmentDto {

    private Long userId;

    @DateTimeFormat
    @NotNull
    private LocalDate from;

    @DateTimeFormat
    @NotNull
    private LocalDate to;

    @NotNull
    private Long productId;

}
