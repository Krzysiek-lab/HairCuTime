package com.example.haircuttime.service.workdefinition;

import com.example.haircuttime.model.dto.workdefinition.CreateWorkDefinitionDto;
import com.example.haircuttime.model.dto.workdefinition.WorkDefinitionDto;
import com.example.haircuttime.model.mapper.WorkDefinitionMapper;
import com.example.haircuttime.repository.WorkDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkDefinitionServiceImpl implements WorkDefinitionService {

    private final WorkDefinitionRepository workDefinitionRepository;
    private final WorkDefinitionMapper workDefinitionMapper;

    @Override
    public List<WorkDefinitionDto> getAllWorkDefinitions() {
        return workDefinitionRepository.findAll().stream()
                .map(workDefinitionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public WorkDefinitionDto addWorkDefinition(CreateWorkDefinitionDto createWorkDefinitionDto) {
        return workDefinitionMapper.toDto(workDefinitionRepository
                .save(workDefinitionMapper
                        .toNewEntity(createWorkDefinitionDto)));
    }
}
