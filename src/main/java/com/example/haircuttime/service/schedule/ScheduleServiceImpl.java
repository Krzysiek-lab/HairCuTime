package com.example.haircuttime.service.schedule;

import com.example.haircuttime.exception.exceptions.UniqueValueException;
import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.workweek.WorkWeekDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.model.entity.WorkWeek;
import com.example.haircuttime.model.mapper.BarberMapper;
import com.example.haircuttime.model.mapper.WorkWeekMapper;
import com.example.haircuttime.model.mapper.WorkYearMapper;
import com.example.haircuttime.repository.BarberRepository;
import com.example.haircuttime.repository.WorkWeekRepository;
import com.example.haircuttime.repository.WorkYearRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final BarberRepository barberRepository;
    private final BarberMapper barberMapper;
    private final WorkYearRepository workYearRepository;
    private final WorkYearMapper workYearMapper;
    private final WorkWeekMapper workWeekMapper;
    private final WorkWeekRepository workWeekRepository;

    //TODO Optional
    @Override
    public BarberDto addWorkYear(Long barberId, Long year) {
        BarberDto barberDto = getBarberDto(barberId);

        if (isWorkYearEmpty(year, barberDto)) {
            throw new UniqueValueException("year for this worker already exists");
        }

        WorkYearDto workYearDto = WorkYearDto.builder()
                .year(year)
                .barberId(barberId)
                .yearSchedule(new TreeMap<>())
                .build();

        barberDto.getWorkYears().add(workYearDto);
        return barberMapper.toDto(barberRepository.save(barberMapper.toEntity(barberDto)));
    }

    @Override
    public BarberDto addWorkWeekToWorkYear(Long barberId, Long year, Long weekNumber) {
        BarberDto barberDto = getBarberDto(barberId);

//        if (!isWorkYearEmpty(year, barberDto)) {
//            throw new UniqueValueException("year for this worker already exists. Year: " + year);
//        }

        if (!isWorkWeekEmpty(year, barberDto, weekNumber)) {
            throw new UniqueValueException("week for this worker already exists. Week number: " + weekNumber);
        }

        WorkWeekDto workWeekDto = workWeekMapper.toDto(workWeekRepository.save(WorkWeek
                .builder()
                .weekAvailability(new TreeMap<>())
                .weekNumber(weekNumber)
                .build()));

        barberDto.setWorkYears(
                barberDto.getWorkYears().stream()
                        .map(workYear -> {
                            if (workYear.getYear().equals(year)) {
                                var yearSchedule = workYear.getYearSchedule();
                                yearSchedule.put(Math.toIntExact(weekNumber), workWeekDto);
                                workYear.setYearSchedule(yearSchedule);
                            }
                            return workYear;
                        }).collect(Collectors.toList())
        );

        return barberMapper.toDto(barberRepository.save(barberMapper.toEntity(barberDto)));
    }

    private BarberDto getBarberDto(Long barberId) {
        BarberDto barberDto = barberMapper.toDto(barberRepository
                .findById(barberId)
                .orElseThrow(() -> new UniqueValueException("barber with id " + barberId + " not found")));
        return barberDto;
    }

    private static boolean isWorkYearEmpty(Long newYear, BarberDto barberDto) {
        return barberDto.getWorkYears().stream()
                .filter(e -> e.getYear().equals(newYear))
                .findAny().isEmpty();
    }

    private static boolean isWorkWeekEmpty(Long newYear, BarberDto barberDto, Long weekNumber) {
        return barberDto.getWorkYears().stream()
                .filter(e -> e.getYear().equals(newYear))
                .filter(e -> e.getYearSchedule().containsKey(weekNumber))
                .findAny().isEmpty();
    }

    //TODO AddWorkWeekToYear
    //TODO AddWorkDaysToWeek
    //TODO UpdateWorkDaysInWeek


//    @Override
//    public WorkYearDto getScheduleOfBarber(Long barberId, Long year) {
//        return workYearMapper.toDto(workYearRepository.findWorkYearByBarberIdAndYear(barberId, year).get());
//    }
//
//    @Override
//    public List<WorkYearDto> getAllSchedules() {
//        return workYearRepository.findAll()
//                .stream()
//                .map(workYearMapper::toDto)
//                .collect(Collectors.toList());
//    }
//
//    //TODO Optional
//    @Override
//    public List<WorkWeekDto> getAllWorkWeeksInYear(Long barberId, Long year) {
//        return workYearRepository.findWorkYearByBarberIdAndYear(barberId, year)
//                .get()
//                .getYearSchedule()
//                .values()
//                .stream()
//                .map(workWeekMapper::toDto)
//                .collect(Collectors.toList());
//    }
//
//    public WorkYearDto addWorkWeekToYear (Long barberId, Long year, Long weekNumber) {
//        Optional<WorkYear> workYear = workYearRepository.findWorkYearByBarberIdAndYear(barberId, year);
//        Optional<WorkWeek> week = workWeekRepository.findWorkWeekByWeekNumber(weekNumber);
//        if (workYear.isPresent()) {
//            if (week.isEmpty()){
//
//
//            }
//
//            return null;
//        }
//        else throw new NoSuchElementException("no work year");
//    }
}
