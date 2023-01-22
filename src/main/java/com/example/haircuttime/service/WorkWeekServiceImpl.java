package com.example.haircuttime.service;

import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.example.haircuttime.model.dto.workweek.WorkWeekDto;
import com.example.haircuttime.model.mapper.WorkDayMapper;
import com.example.haircuttime.model.mapper.WorkWeekMapper;
import com.example.haircuttime.model.schedule.WorkWeek;
import com.example.haircuttime.repository.WorkWeekRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkWeekServiceImpl implements WorkWeekService {

    @Autowired
    private final WorkWeekRepository workWeekRepository;
    private final WorkDayMapper workDayMapper;
    private final WorkWeekMapper workWeekMapper;
    @Override
    public List<WorkDayDto> getDaysInWorkWeek(Long workWeekId) {
        return workWeekRepository.findById(workWeekId)
                .get()
                .getWeekAvailability()
                .values()
                .stream()
                .map(workDayMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public WorkWeekDto addWorkWeek(Long weekNumber) {
        var workWeek = workWeekRepository.findById(weekNumber);
        if (workWeek.isEmpty()){
            return workWeekMapper.toDto(workWeekRepository.save(WorkWeek
                    .builder()
                    .id(0L)
                    .weekNumber(weekNumber)
                    .weekAvailability(new TreeMap<>())
                    .build()));
        }
        else return workWeekMapper.toDto(workWeek.get());
    }

}
