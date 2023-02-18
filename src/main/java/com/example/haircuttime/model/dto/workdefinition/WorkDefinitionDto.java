package com.example.haircuttime.model.dto.workdefinition;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalTime;

@Getter
@Setter
@Builder
public class WorkDefinitionDto {

    private Long id;
    private String name;
    private LocalTime start;
    private LocalTime end;
    private Duration workDuration;
}
