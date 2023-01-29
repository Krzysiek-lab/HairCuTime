package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.example.haircuttime.model.dto.workweek.CreateWorkWeekDto;
import com.example.haircuttime.model.dto.workweek.WorkWeekDto;
import com.example.haircuttime.model.enums.Day;
import com.example.haircuttime.model.entity.WorkDay;
import com.example.haircuttime.model.entity.WorkWeek;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.AbstractMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class WorkWeekMapper {

    private final WorkDayMapper workDayMapper;

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

    public WorkWeekDto toNewEntity(CreateWorkWeekDto createWorkWeekDto) {
        return WorkWeekDto.builder()
                .weekNumber(createWorkWeekDto.getWeekNumber())
                .weekAvailability(new TreeMap<>())
                .build();
    }
    private Map<Day, WorkDay> getWorkDaysDtoToEntities(WorkWeekDto workWeekDto) {
        return workWeekDto
                .getWeekAvailability()
                .entrySet()
                .stream()
                .map((entry) -> new AbstractMap.SimpleEntry<>
                        (entry.getKey(), workDayMapper.toEntity(entry.getValue())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Map<Day, WorkDayDto> getWorkDaysEntityToDto(WorkWeek workWeek) {
        return workWeek
                .getWeekAvailability()
                .entrySet()
                .stream()
                .map((entry) -> new AbstractMap.SimpleEntry<>
                        (entry.getKey(), workDayMapper.toDto(entry.getValue())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
