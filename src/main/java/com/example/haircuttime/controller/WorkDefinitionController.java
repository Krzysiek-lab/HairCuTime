package com.example.haircuttime.controller;

import com.example.haircuttime.model.dto.workdefinition.CreateWorkDefinitionDto;
import com.example.haircuttime.model.dto.workdefinition.WorkDefinitionDto;
import com.example.haircuttime.service.workdefinition.WorkDefinitionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/definition")
@RequiredArgsConstructor
public class WorkDefinitionController {
    private final WorkDefinitionServiceImpl workDefinitionService;

    @GetMapping
    public List<WorkDefinitionDto> getAllDefinitions(){
        return workDefinitionService.getAllWorkDefinitions();
    }
    @PostMapping
    public WorkDefinitionDto addDefinition(
            @RequestBody CreateWorkDefinitionDto createWorkDefinitionDto){
        return workDefinitionService.addWorkDefinition(createWorkDefinitionDto);
    }
}
