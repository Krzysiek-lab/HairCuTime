package com.example.haircuttime.model.dto.availability;


import com.example.haircuttime.CustomAnnotations.AvailabilityAnnotation;
import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.workday.WorkDayDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@AvailabilityAnnotation(message = "can't add second availability in the same time in given day")
public class AvailabilityDto {

    @NotNull
    private Long id;

    @NotNull
    private WorkDayDto workDay;

    @NotNull
    private BarberDto barber;

    @DateTimeFormat
    @NotNull
    private LocalTime startTime;

    @DateTimeFormat
    @NotNull
    private LocalTime endTime;

}
