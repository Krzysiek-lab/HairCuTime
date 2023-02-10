package com.example.haircuttime.service.workyear;

import com.example.haircuttime.model.dto.workyear.CreateWorkYearDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.model.entity.WorkDay;
import com.example.haircuttime.model.entity.WorkYear;
import com.example.haircuttime.model.mapper.WorkDayMapper;
import com.example.haircuttime.model.mapper.WorkYearMapper;
import com.example.haircuttime.repository.BarberRepository;
import com.example.haircuttime.repository.WorkDayRepository;
import com.example.haircuttime.repository.WorkDefinitionRepository;
import com.example.haircuttime.repository.WorkYearRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkYearServiceImpl implements WorkYearService {

    private final WorkYearRepository workYearRepository;

    private final WorkYearMapper workYearMapper;

    private final BarberRepository barberRepository;

    private final WorkDayMapper workDayMapper;

    private final WorkDefinitionRepository workDefinitionRepository;

    private final WorkDayRepository workDayRepository;

    @Override
    public List<WorkYearDto> getAllWorkYears() {
        return workYearRepository.findAll().stream()
                .map(workYearMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public WorkYearDto addWorkYear(CreateWorkYearDto createWorkYearDto) {
        WorkYear workYear = workYearMapper.toNewEntity(createWorkYearDto);
        workYear.setBarber(barberRepository.findById(createWorkYearDto.getBarberId())
                .orElseThrow(EntityNotFoundException::new));
        List<WorkDay> workDays = createWorkYearDto.getWorkDayList().stream()
                .map(createWorkDayDto -> {
                    WorkDay workDay = workDayMapper.toNewEntity(createWorkDayDto);
                    workDay.setWorkYear(workYearRepository.findById(createWorkDayDto
                                    .getWorkYearId())
                            .orElseThrow(EntityNotFoundException::new));
                    workDay.setWorkDefinition(workDefinitionRepository.findById(createWorkDayDto
                                    .getWorkDefinitionId())
                            .orElseThrow(EntityNotFoundException::new));
                    return workDay;
                }).toList();
        workYear.setWorkDayList(new ArrayList<>(workDayRepository.saveAllAndFlush(workDays)));

        return workYearMapper.toDto(workYearRepository.save(workYear));
    }
}
