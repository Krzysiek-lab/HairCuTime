package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.example.haircuttime.model.dto.workweek.WorkWeekDto;
import com.example.haircuttime.model.schedule.Days;
import com.example.haircuttime.model.schedule.WorkDay;
import com.example.haircuttime.model.schedule.WorkWeek;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class WorkWeekMapper {

    private WorkDayMapper workDayMapper;

    public WorkWeek toEntity (WorkWeekDto workWeekDto) {
        return WorkWeek.builder()
                .id(workWeekDto.getId())
                .weekNumber(workWeekDto.getWeekNumber())
                .weekAvailability(getWorkDaysDtoToEntities(workWeekDto))
                .build();
    }

    public WorkWeekDto toDto (WorkWeek workWeek) {
        return WorkWeekDto.builder()
                .id(workWeek.getId())
                .weekNumber(workWeek.getWeekNumber())
                .weekAvailability(getWorkDaysEntityToDto(workWeek))
                .build();
    }
    private Map<Days, WorkDay> getWorkDaysDtoToEntities(WorkWeekDto workWeekDto) {
        return workWeekDto
                .getWeekAvailability()
                .entrySet()
                .stream()
                .map((entry) -> new AbstractMap.SimpleEntry<>
                        (entry.getKey(), workDayMapper.toEntity(entry.getValue())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Map<Days, WorkDayDto> getWorkDaysEntityToDto(WorkWeek workWeek) {
        return workWeek
                .getWeekAvailability()
                .entrySet()
                .stream()
                .map((entry) -> new AbstractMap.SimpleEntry<>
                        (entry.getKey(), workDayMapper.toDto(entry.getValue())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
