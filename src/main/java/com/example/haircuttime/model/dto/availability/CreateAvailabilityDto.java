package com.example.haircuttime.model.dto.availability;


import com.example.haircuttime.CustomAnnotations.AvailabilityAnnotation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AvailabilityAnnotation(message = "can't add second availability in the same time in given day")
public class CreateAvailabilityDto {

    @NotNull
    private Long workDayId;

    @NotNull
    private Long barberId;

    @DateTimeFormat
    @NotNull
    private LocalTime startTime;

    @DateTimeFormat
    @NotNull
    private LocalTime endTime;
}
