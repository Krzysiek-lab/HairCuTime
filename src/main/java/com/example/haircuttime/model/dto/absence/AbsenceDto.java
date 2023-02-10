package com.example.haircuttime.model.dto.absence;

import com.example.haircuttime.CustomAnnotations.AbsenceAnnotation;
import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.entity.Barber;
import com.example.haircuttime.model.entity.WorkDay;
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
public class AbsenceDto {

    @NotNull
    @NotEmpty
    private Long id;

    @NotNull
    @NotEmpty
    private BarberDto barberDto;

    @NotNull
    @NotEmpty
    private LocalTime absenceStart;

    @NotNull
    @NotEmpty
    private LocalTime absenceEnd;

    @NotNull
    @NotEmpty
    private WorkDay workDay;

    @NotNull
    @NotEmpty
    private Barber barber;
}
