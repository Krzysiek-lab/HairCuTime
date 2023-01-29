package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.availability.AvailabilityDto;
import com.example.haircuttime.model.dto.workday.CreateWorkDayDto;
import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.example.haircuttime.model.entity.Absence;
import com.example.haircuttime.model.entity.Availability;
import com.example.haircuttime.model.entity.WorkDay;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class WorkDayMapper {
    private final AbsenceMapper absenceMapper;
    private final AvailabilityMapper availabilityMapper;

    public WorkDay toEntity(WorkDayDto workDayDto) {
        return WorkDay.builder()
                .id(workDayDto.getId())
                .workDefinition(workDayDto.getWorkDefinition())
                .availabilities(getAvailabilitiesDtoList(workDayDto))
                .absences(getAbsenceListFromDto(workDayDto))
                .build();
    }

    public WorkDayDto toDto(WorkDay workDay) {
        return WorkDayDto.builder()
                .id(workDay.getId())
                .workDefinition(workDay.getWorkDefinition())
                .availabilities(getAvailabilitiesList(workDay))
                .absences(getAbsenceDtoListFromAbsence(workDay))
                .build();
    }

    public WorkDay toNewEntity(CreateWorkDayDto createWorkDayDto) {
        return WorkDay.builder()
                .id(0L)
                .workDefinition(createWorkDayDto.getWorkDefinition())
                .availabilities(getAvailabilitiesDtoList(createWorkDayDto))
                .absences(getAbsenceListFromDto(createWorkDayDto))
                .build();
    }


    private List<AvailabilityDto> getAvailabilitiesList(WorkDay workDay) {
        return workDay.getAvailabilities()
                .stream()
                .map(availabilityMapper::toDto)
                .collect(Collectors.toList());
    }
    private List<Availability> getAvailabilitiesDtoList(WorkDayDto workDayDto) {
        return workDayDto.getAvailabilities()
                .stream()
                .map(availabilityMapper::toEntity)
                .collect(Collectors.toList());
    }

    private List<Availability> getAvailabilitiesDtoList(CreateWorkDayDto createWorkDayDto) {
        return createWorkDayDto.getAvailabilities()
                .stream()
                .map(availabilityMapper::toEntity)
                .collect(Collectors.toList());
    }

    private List<Absence> getAbsenceListFromDto(WorkDayDto workDayDto) {
        return workDayDto.getAbsences()
                .stream()
                .map(absenceMapper::toEntity)
                .collect(Collectors.toList());
    }

    private List<AbsenceDto> getAbsenceDtoListFromAbsence(WorkDay workDay) {
        return workDay.getAbsences()
                .stream()
                .map(absenceMapper::toDto)
                .collect(Collectors.toList());
    }

    private List<Absence> getAbsenceListFromDto(CreateWorkDayDto createWorkDayDto) {
        return createWorkDayDto.getAbsences()
                .stream()
                .map(absenceMapper::toEntity)
                .collect(Collectors.toList());
    }

}
