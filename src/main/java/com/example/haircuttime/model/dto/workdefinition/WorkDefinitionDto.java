package com.example.haircuttime.model.dto.workdefinition;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.LocalTime;

@Getter
@Setter
@Builder
public class WorkDefinitionDto {

    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @DateTimeFormat
    private LocalTime start;

    @NotNull
    @DateTimeFormat
    private LocalTime end;

    @Enumerated(EnumType.STRING)
    private Duration workDuration;
}
