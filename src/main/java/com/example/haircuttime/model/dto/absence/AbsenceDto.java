package com.example.haircuttime.model.dto.absence;

import com.example.haircuttime.CustomAnnotations.AbsenceAnnotation;
import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.workday.WorkDayDto;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalTime;

@Builder
@Getter
@Setter
@AbsenceAnnotation(message = "This Barber already has absence in given time")
public class AbsenceDto {

    @NotNull
    @NotEmpty
    private Long id;

    //@NotNull
    //@NotEmpty
    private BarberDto barber;

    //@NotNull
    ///@NotEmpty
    private LocalTime absenceStart;

    //@NotNull
   // @NotEmpty
    private LocalTime absenceEnd;

    //@NotNull
    //@NotEmpty
    private WorkDayDto workDay;
}
