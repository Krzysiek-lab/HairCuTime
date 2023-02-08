package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.workday.CreateWorkDayDto;
import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.example.haircuttime.model.entity.WorkDay;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class WorkDayMapper {
    public WorkDay toEntity(WorkDayDto workDayDto) {
        return WorkDay.builder()
                .id(workDayDto.getId())
                .dayInYear(workDayDto.getDayInYear())
                //.availabilities(workDayDto.getAvailabilities())
                //.absences(workDayDto.getAbsences())
                .build();
    }

    public WorkDayDto toDto(WorkDay workDay) {
        return WorkDayDto.builder()
                .id(workDay.getId())
                .dayInYear(workDay.getDayInYear())
                //.availabilities(workDay.getAvailabilities())
                //.absences(workDay.getAbsences())
                .build();
    }

    public WorkDay toNewEntity(CreateWorkDayDto createWorkDayDto) {
        return WorkDay.builder()
                .dayInYear(createWorkDayDto.getDayInYear())
                //.availabilities(new ArrayList<>())
                //.absences(new ArrayList<>())
                .build();
    }

}
