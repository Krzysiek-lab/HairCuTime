package com.example.haircuttime.model.dto.availability;


import com.example.haircuttime.CustomAnnotations.AvailabilityAnnotation;
import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.entity.WorkDay;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

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
    @NotEmpty
    private Long id;

    @NotNull
    @NotEmpty
    private WorkDay workDay;

    @NotNull
    @NotEmpty
    private BarberDto barberDto;

    @NotNull
    @NotEmpty
    private LocalTime startTime;

    @NotNull
    @NotEmpty
    private LocalTime endTime;

}
