package com.example.haircuttime.model.dto.availability;


import com.example.haircuttime.CustomAnnotations.AvailabilityAnnotation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.*;

import java.time.LocalTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AvailabilityAnnotation(message = "can't add second availability in the same time in given day")
public class CreateAvailabilityDto {

    @NotNull
    @NotEmpty
    private Long workDayId;

    @NotNull
    @NotEmpty
    private Long barberId;

    @NotNull
    @NotEmpty
    private LocalTime startTime;

    @NotNull
    @NotEmpty
    private LocalTime endTime;
}
