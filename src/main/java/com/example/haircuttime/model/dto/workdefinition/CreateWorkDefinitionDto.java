package com.example.haircuttime.model.dto.workdefinition;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalTime;

@Setter
@Getter
@Builder
public class CreateWorkDefinitionDto {

    private String name;
    private LocalTime start;
    private LocalTime end;
    private Duration duration;
}
