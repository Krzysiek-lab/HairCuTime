package com.example.haircuttime.model.dto.workdefinition;

import lombok.Data;

import java.time.Duration;
import java.time.LocalTime;

@Data
public class CreateWorkDefinitionDto {

    private String name;
    private LocalTime start;
    private LocalTime end;
    private Duration duration;
}
