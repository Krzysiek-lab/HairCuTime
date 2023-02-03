package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.workdefinition.CreateWorkDefinitionDto;
import com.example.haircuttime.model.dto.workdefinition.WorkDefinitionDto;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Data
@Component
public class WorkDefinitionMapper {

    private final WorkDayMapper workDayMapper;

    public com.example.haircuttime.model.entity.WorkDefinition toNewEntity(CreateWorkDefinitionDto createWorkDefinitionDto) {
        return com.example.haircuttime.model.entity.WorkDefinition.builder()
                .name(createWorkDefinitionDto.getName())
                .start(createWorkDefinitionDto.getStart())
                .end(createWorkDefinitionDto.getEnd())
                .workDuration(Duration.between(createWorkDefinitionDto.getStart(), createWorkDefinitionDto.getEnd()))
                .workDayList(new ArrayList<>())
                .build();
    }

    public com.example.haircuttime.model.entity.WorkDefinition toEntity(WorkDefinitionDto workDefinition) {
        return com.example.haircuttime.model.entity.WorkDefinition.builder()
                .id(workDefinition.getId())
                .name(workDefinition.getName())
                .start(workDefinition.getStart())
                .end(workDefinition.getEnd())
                .workDuration(Duration.between(workDefinition.getStart(), workDefinition.getEnd()))
                .workDayList(workDefinition
                        .getWorkDayList().stream()
                        .map(workDayMapper::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    public WorkDefinitionDto toDto(com.example.haircuttime.model.entity.WorkDefinition workDefinition) {
        return WorkDefinitionDto.builder()
                .id(workDefinition.getId())
                .name(workDefinition.getName())
                .start(workDefinition.getStart())
                .end(workDefinition.getEnd())
                .workDuration(Duration.between(workDefinition.getStart(), workDefinition.getEnd()))
                .workDayList(workDefinition
                        .getWorkDayList().stream()
                        .map(workDayMapper::toDto)
                        .collect(Collectors.toList()))
                .build();
    }
}
