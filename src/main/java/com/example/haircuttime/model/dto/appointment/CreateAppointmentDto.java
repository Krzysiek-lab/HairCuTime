package com.example.haircuttime.model.dto.appointment;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
public class CreateAppointmentDto {
    @NotNull
    private Long userId;

    @DateTimeFormat
    private LocalDate date;

    @DateTimeFormat(iso= DateTimeFormat.ISO.TIME)
    private LocalTime time;

    @NotNull
    private Long serviceLength;

    @NotNull
    private Long productId;

}
