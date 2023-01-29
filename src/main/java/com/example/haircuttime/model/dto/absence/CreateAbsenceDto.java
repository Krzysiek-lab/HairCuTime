package com.example.haircuttime.model.dto.absence;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.entity.WorkDay;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Builder
@Getter
@Setter
public class CreateAbsenceDto {
    private BarberDto barberDto;
    private WorkDay workDay;
    private LocalTime absenceStart;
    private LocalTime absenceEnd;
}
