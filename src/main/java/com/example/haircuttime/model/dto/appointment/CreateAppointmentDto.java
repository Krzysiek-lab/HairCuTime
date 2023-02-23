package com.example.haircuttime.model.dto.appointment;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
public class CreateAppointmentDto {
    @NotNull
    private Long userId;

    private LocalDate date;

    private LocalTime time;

    @NotNull
    private Long serviceLength;

    @NotNull
    private Long productId;

}
