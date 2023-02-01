package com.example.haircuttime.service.workdefinition;

import com.example.haircuttime.model.dto.workdefinition.CreateWorkDefinitionDto;
import com.example.haircuttime.model.entity.WorkDefinition;
import com.example.haircuttime.model.mapper.WorkDefinitionMapper;
import com.example.haircuttime.repository.WorkDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkDefinitionServiceImpl implements WorkDefinitionService {

    private final WorkDefinitionRepository workDefinitionRepository;
    private final WorkDefinitionMapper workDefinitionMapper;

    @Override
    public List<WorkDefinition> getAllWorkDefinitions() {
        return workDefinitionRepository.findAll();
    }

    @Override
    public List<WorkDefinition> addWorkDefinition(CreateWorkDefinitionDto createWorkDefinitionDto) {
        workDefinitionRepository.save(workDefinitionMapper.toNewEntity(createWorkDefinitionDto));
        return getAllWorkDefinitions();
    }
}
