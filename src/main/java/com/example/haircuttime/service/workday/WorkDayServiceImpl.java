package com.example.haircuttime.service.workday;

import com.example.haircuttime.model.dto.workday.CreateWorkDayDto;
import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.example.haircuttime.model.entity.WorkDay;
import com.example.haircuttime.model.mapper.WorkDayMapper;
import com.example.haircuttime.repository.WorkDayRepository;
import com.example.haircuttime.repository.WorkDefinitionRepository;
import com.example.haircuttime.repository.WorkYearRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkDayServiceImpl implements WorkDayService {

    private final WorkDayRepository workDayRepository;

    private final WorkDayMapper workDayMapper;

    private final WorkYearRepository workYearRepository;

    private final WorkDefinitionRepository workDefinitionRepository;

    @Override
    public List<WorkDayDto> getAllWorkDays() {
        return workDayRepository.findAll().stream()
                .map(workDayMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public WorkDayDto addWorkDay(CreateWorkDayDto createWorkDayDto) {
        WorkDay workDay = workDayMapper.toNewEntity(createWorkDayDto);
        workDay.setWorkYear(workYearRepository.findById(createWorkDayDto.getWorkYearId())
                .orElseThrow(EntityNotFoundException::new));
        workDay.setWorkDefinition(workDefinitionRepository.findById(createWorkDayDto.getWorkDefinitionId())
                .orElseThrow(EntityNotFoundException::new));

        return workDayMapper.toDto(workDayRepository.save(workDay));
    }
}
