package com.example.haircuttime.model.dto.workdefinition;

import com.example.haircuttime.model.dto.workday.WorkDayDto;
import lombok.Builder;
import lombok.Data;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
public class WorkDefinitionDto {

    private Long id;
    private String name;
    private LocalTime start;
    private LocalTime end;
    private Duration workDuration;
    private List<WorkDayDto> workDayList;
}
