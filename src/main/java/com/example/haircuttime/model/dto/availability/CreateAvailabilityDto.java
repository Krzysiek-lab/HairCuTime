package com.example.haircuttime.model.dto.availability;



import com.example.haircuttime.CustomAnnotations.AvailabilityAnnotation;
import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.entity.WorkDay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
