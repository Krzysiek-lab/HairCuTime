package com.example.haircuttime.model.dto.workday;

import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.availability.AvailabilityDto;
import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.barber.CreateBarberDto;
import com.example.haircuttime.model.enums.WorkDefinition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class WorkDayDto {
    private Long id;
    private WorkDefinition workDefinition;
    private BarberDto barberDto;
    private List<AbsenceDto> absences = new ArrayList<>();
    private List<AvailabilityDto> availabilities = new ArrayList<>();
}

