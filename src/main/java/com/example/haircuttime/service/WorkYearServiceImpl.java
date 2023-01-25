package com.example.haircuttime.service;

import com.example.haircuttime.model.dto.workweek.CreateWorkWeekDto;
import com.example.haircuttime.model.dto.workweek.WorkWeekDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.model.entity.WorkWeek;
import com.example.haircuttime.model.mapper.WorkWeekMapper;
import com.example.haircuttime.model.mapper.WorkYearMapper;
import com.example.haircuttime.model.entity.WorkYear;
import com.example.haircuttime.repository.WorkWeekRepository;
import com.example.haircuttime.repository.WorkYearRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkYearServiceImpl implements WorkYearService {
    private final WorkYearRepository workYearRepository;
    private final WorkYearMapper workYearMapper;
    private final WorkWeekMapper workWeekMapper;
    private final WorkWeekRepository workWeekRepository;

    //TODO Optional
    @Override
    public WorkYearDto addWorkYear(Long barberId, Long year) {
        var newYear = workYearRepository.findWorkYearByBarberIdAndYear(barberId, year);
        if (newYear.isEmpty()) {
            var newWorkYear = workYearRepository.save(WorkYear.builder()
                    .year(year)
                    .barberId(barberId)
                    .yearSchedule(new TreeMap<>())
                    .build());
            return workYearMapper.toDto(newWorkYear);
        } else throw new NoSuchElementException("No such year for this barber");
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

    public WorkYearDto addWorkWeekToYear (Long barberId, Long year, Long weekNumber) {
        Optional<WorkYear> workYear = workYearRepository.findWorkYearByBarberIdAndYear(barberId, year);
        Optional<WorkWeek> week = workWeekRepository.findWorkWeekByBarberIdAndWeekNumber(barberId, weekNumber);
        if (workYear.isPresent()) {
            if (week.isEmpty()){


            }

            return null;
        }
        else throw new NoSuchElementException("no work year");
    }
}
