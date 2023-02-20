package com.example.haircuttime.model.dto.workdefinition;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalTime;

@Setter
@Getter
@Builder
public class CreateWorkDefinitionDto {

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
    private Duration duration;
}
