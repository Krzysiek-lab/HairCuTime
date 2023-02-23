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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class WorkDayMapper {

    private final WorkYearMapper workYearMapper;

    private final AvailabilityMapper availabilityMapper;

    private final AbsenceMapper absenceMapper;
    private final WorkDefinitionMapper workDefinitionMapper;


    public WorkDay toEntity(WorkDayDto workDayDto) {
        return WorkDay.builder()
                .id(workDayDto.getId())
                .dayInYear(workDayDto.getDayInYear())
                .workYear(workYearMapper.toEntity(workDayDto.getWorkYear()))
                .workDefinition(workDefinitionMapper.toEntity(workDayDto.getWorkDefinition()))
                .availabilities(getAvailabilities(workDayDto))
                .absences(getAbsences(workDayDto))
                .build();
    }

    public WorkDayDto toDto(WorkDay workDay) {
        return WorkDayDto.builder()
                .id(workDay.getId())
                .dayInYear(workDay.getDayInYear())
                .workYear(workYearMapper.toDto(workDay.getWorkYear()))
                .workDefinition(workDefinitionMapper.toDto(workDay.getWorkDefinition()))
                .availabilities(getAvailabilityDto(workDay))
                .absences(getAbsenceDto(workDay))
                .build();
    }

    public WorkDay toNewEntity(CreateWorkDayDto createWorkDayDto) {
        return WorkDay.builder()
                .dayInYear(createWorkDayDto.getDayInYear())
                .availabilities(new ArrayList<>())
                .absences(new ArrayList<>())
                .build();
    }

    private List<Availability> getAvailabilities(WorkDayDto workDayDto) {
        return workDayDto.getAvailabilities().stream()
                .map(availabilityMapper::toEntity)
                .collect(Collectors.toList());
    }

    private List<AvailabilityDto> getAvailabilityDto(WorkDay workDay) {
        return workDay.getAvailabilities().stream()
                .map(availabilityMapper::toDto)
                .collect(Collectors.toList());
    }

    private List<Absence> getAbsences(WorkDayDto workDayDto) {
        return workDayDto.getAbsences().stream()
                .map(absenceMapper::toEntity)
                .collect(Collectors.toList());
    }

    private List<AbsenceDto> getAbsenceDto(WorkDay workDay) {
        return workDay.getAbsences().stream()
                .map(absenceMapper::toDto)
                .collect(Collectors.toList());
    }
}
