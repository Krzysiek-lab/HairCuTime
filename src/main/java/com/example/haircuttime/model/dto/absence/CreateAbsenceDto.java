package com.example.haircuttime.model.dto.absence;


import com.example.haircuttime.CustomAnnotations.AbsenceAnnotation;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
