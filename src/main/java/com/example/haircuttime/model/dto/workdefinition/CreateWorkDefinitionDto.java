package com.example.haircuttime.model.dto.workdefinition;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalTime;

@Setter
@Getter
public class CreateWorkDefinitionDto {

    private String name;
    private LocalTime start;
    private LocalTime end;
    private Duration duration;
}
