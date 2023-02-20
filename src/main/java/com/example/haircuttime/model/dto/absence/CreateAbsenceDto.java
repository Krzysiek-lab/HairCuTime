package com.example.haircuttime.model.dto.absence;


import com.example.haircuttime.CustomAnnotations.AbsenceAnnotation;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Builder
@Getter
@Setter
@AbsenceAnnotation(message = "This Barber already has absence in given time")
public class CreateAbsenceDto {

    @NotNull
    private Long barberId;

    @NotNull
    private Long workDayId;

    @NotNull
    private LocalTime absenceStart;

    @NotNull
    private LocalTime absenceEnd;
}
