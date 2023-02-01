package com.example.haircuttime.service.workdefinition;

import com.example.haircuttime.model.dto.workdefinition.CreateWorkDefinitionDto;
import com.example.haircuttime.model.entity.WorkDefinition;

import java.util.List;

public interface WorkDefinitionService {
    List<WorkDefinition> getAllWorkDefinitions();
    List<WorkDefinition> addWorkDefinition(CreateWorkDefinitionDto createWorkDefinitionDto);

}
