package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.model.entity.WorkYear;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class WorkYearMapper {

    private WorkWeekMapper workWeekMapper;

    public WorkYear toEntity (WorkYearDto workYearDto){
        return WorkYear.builder()
                .id(workYearDto.getId())
                .year(workYearDto.getYear())
                .barberId(workYearDto.getBarberId())
                .yearSchedule(workYearDto
                        .getYearSchedule()
                        .entrySet()
                        .stream()
                        .map((entry) -> new AbstractMap.SimpleEntry<>
                                (entry.getKey(), workWeekMapper.toEntity(entry.getValue())))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
                .build();
    }

    public WorkYearDto toDto (WorkYear workYear) {
        return WorkYearDto.builder()
                .id(workYear.getId())
                .year(workYear.getYear())
                .barberId(workYear.getBarberId())
                .yearSchedule(workYear
                        .getYearSchedule()
                        .entrySet()
                        .stream()
                        .map((entry) -> new AbstractMap.SimpleEntry<>
                                (entry.getKey(), workWeekMapper.toDto(entry.getValue())))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
                .build();
    }

}