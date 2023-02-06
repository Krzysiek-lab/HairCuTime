package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.workdefinition.CreateWorkDefinitionDto;
import com.example.haircuttime.model.dto.workdefinition.WorkDefinitionDto;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Data
@Component
public class WorkDefinitionMapper {

    public com.example.haircuttime.model.entity.WorkDefinition toNewEntity(CreateWorkDefinitionDto createWorkDefinitionDto) {
        return com.example.haircuttime.model.entity.WorkDefinition.builder()
                .name(createWorkDefinitionDto.getName())
                .start(createWorkDefinitionDto.getStart())
                .end(createWorkDefinitionDto.getEnd())
                .workDuration(Duration.between(createWorkDefinitionDto.getStart(), createWorkDefinitionDto.getEnd()))
                .build();
    }

    public com.example.haircuttime.model.entity.WorkDefinition toEntity(WorkDefinitionDto workDefinition) {
        return com.example.haircuttime.model.entity.WorkDefinition.builder()
                .id(workDefinition.getId())
                .name(workDefinition.getName())
                .start(workDefinition.getStart())
                .end(workDefinition.getEnd())
                .workDuration(workDefinition.getWorkDuration())
                .build();
    }

    public WorkDefinitionDto toDto(com.example.haircuttime.model.entity.WorkDefinition workDefinition) {
        return WorkDefinitionDto.builder()
                .id(workDefinition.getId())
                .name(workDefinition.getName())
                .start(workDefinition.getStart())
                .end(workDefinition.getEnd())
                .workDuration(workDefinition.getWorkDuration())
                .build();
    }
}
