package com.example.haircuttime.model.dto.absence;

import com.example.haircuttime.CustomAnnotations.AbsenceAnnotation;
import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.workday.WorkDayDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Builder
@Getter
@Setter
@AbsenceAnnotation(message = "This Barber already has absence in given time")
public class AbsenceDto {

    @NotNull(message = "cannot be null")
    // @NotEmpty
    private Long id;


    @NotNull(message = "cannot be null")
    //@NotEmpty
    private BarberDto barber;


    @NotNull(message = "cannot be null")
    //  @NotEmpty
    private LocalTime absenceStart;

    @NotNull(message = "cannot be null")
    // @NotEmpty
    private LocalTime absenceEnd;

    @NotNull(message = "cannot be null")
    //  @NotEmpty
    private WorkDayDto workDay;

    @NotNull(message = "cannot be null")
    // @NotEmpty
    private BarberDto barber;
}
