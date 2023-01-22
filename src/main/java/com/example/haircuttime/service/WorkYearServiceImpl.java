package com.example.haircuttime.service;

import com.example.haircuttime.model.dto.workweek.WorkWeekDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.model.mapper.WorkWeekMapper;
import com.example.haircuttime.model.mapper.WorkYearMapper;
import com.example.haircuttime.model.schedule.WorkYear;
import com.example.haircuttime.repository.WorkYearRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkYearServiceImpl implements WorkYearService {
    private final WorkYearRepository workYearRepository;
    private final WorkYearMapper workYearMapper;
    private final WorkWeekMapper workWeekMapper;

    //TODO Optional
    @Override
    public WorkYearDto addWorkYear(Long barberId, Long year) {
       var newYear = workYearRepository.findWorkYearByBarberIdAndYear(barberId, year);
       if (newYear.isEmpty()){
           return workYearMapper.toDto(workYearRepository.save(WorkYear.builder()
                   .id(0L)
                   .barberId(barberId)
                   .yearSchedule(new TreeMap<>())
                   .build()));
       }else throw new NoSuchElementException("No such year for this barber");

    }

    //TODO Optional
    @Override
    public WorkYearDto getScheduleOfBarber(Long barberId, Long year) {
        return workYearMapper.toDto(workYearRepository.findWorkYearByBarberIdAndYear(barberId, year).get());
    }

    @Override
    public List<WorkYearDto> getAllSchedules() {
        return workYearRepository.findAll()
                .stream()
                .map(workYearMapper::toDto)
                .collect(Collectors.toList());
    }

    //TODO Optional
    @Override
    public List<WorkWeekDto> getAllWorkWeeksInYear(Long barberId, Long year) {
        return workYearRepository.findWorkYearByBarberIdAndYear(barberId, year)
                .get()
                .getYearSchedule()
                .values()
                .stream()
                .map(workWeekMapper::toDto)
                .collect(Collectors.toList());
    }
}
