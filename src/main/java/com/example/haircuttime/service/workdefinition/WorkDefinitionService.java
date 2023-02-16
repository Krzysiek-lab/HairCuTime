package com.example.haircuttime.service.workdefinition;

import com.example.haircuttime.model.dto.workdefinition.CreateWorkDefinitionDto;
import com.example.haircuttime.model.dto.workdefinition.WorkDefinitionDto;

import java.util.List;

public interface WorkDefinitionService {
    List<WorkDefinitionDto> getAllWorkDefinitions();

    WorkDefinitionDto addWorkDefinition(CreateWorkDefinitionDto createWorkDefinitionDto);

}
