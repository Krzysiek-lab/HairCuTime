package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.workdefinition.CreateWorkDefinitionDto;
import com.example.haircuttime.model.dto.workdefinition.WorkDefinitionDto;
import com.example.haircuttime.model.entity.WorkDefinition;
import org.springframework.stereotype.Component;


@Component
public class WorkDefinitionMapper {

    public WorkDefinition toNewEntity(CreateWorkDefinitionDto createWorkDefinitionDto) {
        return WorkDefinition.builder()
                .name(createWorkDefinitionDto.getName())
                .start(createWorkDefinitionDto.getStart())
                .end(createWorkDefinitionDto.getEnd())
                .build();
    }

    public WorkDefinition toEntity(WorkDefinitionDto workDefinition) {
        return WorkDefinition.builder()
                .id(workDefinition.getId())
                .name(workDefinition.getName())
                .start(workDefinition.getStart())
                .end(workDefinition.getEnd())
                .build();
    }

    public WorkDefinitionDto toDto(WorkDefinition workDefinition) {
        return WorkDefinitionDto.builder()
                .id(workDefinition.getId())
                .name(workDefinition.getName())
                .start(workDefinition.getStart())
                .end(workDefinition.getEnd())
                .build();
    }
}
