package com.example.haircuttime.model.dto.availability;


import com.example.haircuttime.model.schedule.WorkDay;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;

@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class AvailabilityDto {

    private Long id;
    private WorkDay workDay;
    private Long barberId;
    private LocalTime startTime;
    private LocalTime endTime;

}
