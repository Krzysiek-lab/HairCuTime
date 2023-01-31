package com.example.haircuttime.service.schedule;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.workday.CreateWorkDayDto;
import com.example.haircuttime.model.dto.workyear.CreateWorkYearDto;
import com.example.haircuttime.model.entity.WorkDay;
import com.example.haircuttime.model.entity.WorkYear;
import com.example.haircuttime.model.enums.WorkDefinition;
import com.example.haircuttime.model.mapper.BarberMapper;
import com.example.haircuttime.model.mapper.WorkDayMapper;
import com.example.haircuttime.model.mapper.WorkYearMapper;
import com.example.haircuttime.repository.BarberRepository;
import com.example.haircuttime.repository.WorkDayRepository;
import com.example.haircuttime.exception.exceptions.*;

import com.example.haircuttime.repository.WorkYearRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final BarberRepository barberRepository;
    private final WorkDayRepository workDayRepository;
    private final WorkYearRepository workYearRepository;
    private final BarberMapper barberMapper;
    private final WorkDayMapper workDayMapper;
    private final WorkYearMapper workYearMapper;

    @Override
    public BarberDto addWorkYear(Long barberId, Long year) {
        BarberDto barberDto = getBarberDto(barberId);

        if (!isWorkYearAbsent(year, barberDto)) {
            throw new UniqueValueException(String.format("year %d for this worker id %d already exists", year, barberId));
        }

        var createWorkYearDto = workYearMapper.toNewEntity(CreateWorkYearDto.builder()
                .barberId(barberId)
                .year(year)
                .workDayList(new ArrayList<>())
                .build());
        var newWorkYear = workYearRepository.save(createWorkYearDto);

        barberDto.getWorkYears().add(workYearMapper.toDto(newWorkYear));
        return barberMapper.toDto(barberRepository.save(barberMapper.toEntity(barberDto)));
    }

    @Override
    public BarberDto addWorkDay(Long barberId, Long year, Long dayInYear, WorkDefinition workDefinition) {
        BarberDto barberDto = getBarberDto(barberId);

        var yearDto = barberDto.getWorkYears().stream().filter(e -> e.getYear().equals(year))
                .findFirst()
                .orElseThrow(() -> new UniqueValueException(String.format("No year %d for this worker id %d", year, barberId)));
        var yearSchedule =yearDto.getWorkDayList();

        if (yearSchedule.stream()
                .filter(e->e.getDayInYear()
                        .equals(dayInYear))
                .findFirst()
                .isEmpty()) {

            WorkDay newWorkDayDefinition = WorkDay.builder()
                    .workYear(yearSchedule.stream()
                            .filter(e->e.getDayInYear()
                                    .equals(dayInYear))
                            .findFirst().get().getWorkYear())
                    .dayInYear(dayInYear)
                    .workDefinition(workDefinition)
                    .availabilities(new ArrayList<>())
                    .absences(new ArrayList<>())
                    .build();

            WorkDay newWorkDay = workDayRepository.save(newWorkDayDefinition);
            yearSchedule.add(Math.toIntExact(newWorkDay.getDayInYear()), workDayMapper.toDto(newWorkDay));
            yearDto.setWorkDayList(yearSchedule);
            var newWorkYear = workYearRepository.save(workYearMapper.toEntity(yearDto));
            barberDto.getWorkYears().add(Math.toIntExact(year), workYearMapper.toDto(newWorkYear));
            return barberMapper.toDto(barberRepository.save(barberMapper.toEntity(barberDto)));
        } else throw new UniqueValueException(String.format("Day for barber ID %d exist", barberId));
    }

    private BarberDto getBarberDto(Long barberId) {
        return barberMapper.toDto(barberRepository
                .findById(barberId)
                .orElseThrow(() -> new UniqueValueException("barber with id " + barberId + " not found")));
    }

    private boolean isWorkYearAbsent(Long newYear, BarberDto barberDto) {
        return barberDto.getWorkYears().stream()
                .noneMatch(e -> e.getYear().equals(newYear));
    }
//
//    @Override
//    public BarberDto addEmptyWorkWeekToWorkYear(Long barberId, Long year, Long weekNumber) {
//        BarberDto barberDto = getBarberDto(barberId);
//
//        if (isWorkYearAbsent(year, barberDto)) {
//            throw new UniqueValueException(String.format("year %d for this worker ID %d does not exists", year, barberId));
//        }
//
//        if (!isWorkWeekAbsent(year, barberDto, weekNumber)) {
//            throw new UniqueValueException("week for this worker already exists. Week number: " + weekNumber);
//        }
//
//        WorkWeekDto workWeekDto = workWeekMapper.toDto(workWeekRepository.save(WorkDayNew
//                .builder()
//                .weekAvailability(new TreeMap<>())
//                .weekNumber(weekNumber)
//                .build()));
//        barberDto.setWorkYears(
//                barberDto.getWorkYears().stream()
//                        .peek(workYear -> {
//                            if (workYear.getYear().equals(year)) {
//                                var yearSchedule = workYear.getYearSchedule();
//                                yearSchedule.put(Math.toIntExact(weekNumber), workWeekDto);
//                                workYear.setYearSchedule(yearSchedule);
//                            }
//                        }).collect(Collectors.toList())
//        );
//
//        return barberMapper.toDto(barberRepository.save(barberMapper.toEntity(barberDto)));
//        return null;
//    }

//    @Override
//    public BarberDto addWorkDayToWorkWeek(Long barberId, Long year, Long weekNumber, Day day, CreateWorkDayDto createWorkDayDto) {
//        BarberDto barberDto = getBarberDto(barberId);
//        if (isWorkYearAbsent(year, barberDto)) {
//            throw new UniqueValueException(String.format("year %d for this worker ID %d does not exists", year, barberId));
//        }
//
//        if (isWorkWeekAbsent(year, barberDto, weekNumber)) {
//            throw new UniqueValueException("week for this worker does not exists. Week number: " + weekNumber);
//        }
//
//        barberDto.setWorkYears(barberDto.getWorkYears()
//                .stream()
//                .map(workYear -> {
//                    if (workYear.getYear().equals(year)) {
//                        var yearSchedule = workYear.getYearSchedule();
//                        var weekSchedule = yearSchedule.get(Math.toIntExact(weekNumber)).getWeekAvailability();
//                        weekSchedule.put(day, workDayMapper.toDto(workDayMapper.toNewEntity(createWorkDayDto)));
//                    }
//                    return workYear;
//                })
//                .collect(Collectors.toList())
//        );
//        return barberMapper.toDto(barberRepository.save(barberMapper.toEntity(barberDto)));
//        return null;
//    }

//    @Override
//    public BarberDto addWorkWeekToWorkYear(Long barberId, Long year, CreateWorkWeekDto createWorkWeekDto) {
//        BarberDto barberDto = getBarberDto(barberId);
//
//        if (!isWorkYearAbsent(year, barberDto)) {
//            throw new UniqueValueException(String.format("year %d for this worker %d already exists", year, barberId));
//        }
//
//        var workWeekToSave = workWeekMapper.toNewEntity(createWorkWeekDto);
//
//        workWeekToSave.getWeekAvailability().forEach((key, value) -> workDayRepository.save(value));
//        WorkWeekDto updatedWorkWeek = workWeekMapper.toDto(workWeekRepository.save(workWeekToSave));
//
//        barberDto.setWorkYears(
//                barberDto.getWorkYears().stream()
//                        .map(workYear -> {
//                            if (workYear.getYear().equals(year)) {
//                                var yearSchedule = workYear.getYearSchedule();
//                                yearSchedule.put(Math.toIntExact(updatedWorkWeek.getWeekNumber()), updatedWorkWeek);
//                                workYear.setYearSchedule(yearSchedule);
//                            }
//                            return workYear;
//                        }).collect(Collectors.toList())
//        );
//
//        return barberMapper.toDto(barberRepository.save(barberMapper.toEntity(barberDto)));
//        return null;
//    }

//    private static boolean isWorkWeekAbsent(Long newYear, BarberDto barberDto, Long weekNumber) {
//        return barberDto.getWorkYears().stream()
//                .filter(e -> e.getYear().equals(newYear))
//                .noneMatch(e -> e.getYearSchedule().containsKey(Math.toIntExact(weekNumber)));
//    }

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
