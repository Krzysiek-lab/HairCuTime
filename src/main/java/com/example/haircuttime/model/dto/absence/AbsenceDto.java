package com.example.haircuttime.model.dto.absence;

import com.example.haircuttime.CustomAnnotations.AbsenceAnnotation;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

@Builder
@Getter
@Setter
@AbsenceAnnotation(message = "This Barber already has absence in given time")
public class AbsenceDto {

    @NotNull(message = "cannot be null")
    private Long id;

//    @NotNull(message = "cannot be null")
//    private BarberDto barber;

    @NotNull(message = "cannot be null")
    @DateTimeFormat
    private LocalTime absenceStart;

    @NotNull(message = "cannot be null")
    @DateTimeFormat
    private LocalTime absenceEnd;

//    @NotNull(message = "cannot be null")
//    private WorkDayDto workDay;
}
