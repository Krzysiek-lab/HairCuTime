package com.example.haircuttime.service.schedule;

import com.example.haircuttime.exception.exceptions.UniqueValueException;
import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.workweek.CreateWorkWeekDto;
import com.example.haircuttime.model.dto.workweek.WorkWeekDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.model.entity.WorkWeek;
import com.example.haircuttime.model.mapper.BarberMapper;
import com.example.haircuttime.model.mapper.WorkWeekMapper;
import com.example.haircuttime.repository.BarberRepository;
import com.example.haircuttime.repository.WorkDayRepository;
import com.example.haircuttime.repository.WorkWeekRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final BarberRepository barberRepository;
    private final WorkWeekRepository workWeekRepository;
    private final WorkDayRepository workDayRepository;
    private final BarberMapper barberMapper;
    private final WorkWeekMapper workWeekMapper;
    //TODO Optional
    @Override
    public BarberDto addWorkYear(Long barberId, Long year) {
        BarberDto barberDto = getBarberDto(barberId);

        if (!isWorkYearAbsent(year, barberDto)) {
            throw new UniqueValueException(String.format("year %d for this worker %d already exists", year, barberId));
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
    public BarberDto addEmptyWorkWeekToWorkYear(Long barberId, Long year, Long weekNumber) {
        BarberDto barberDto = getBarberDto(barberId);

        if (isWorkYearAbsent(year, barberDto)) {
            throw new UniqueValueException(String.format("year %d for this worker ID %d does not exists", year, barberId));
        }

        if (!isWorkWeekAbsent(year, barberDto, weekNumber)) {
            throw new UniqueValueException("week for this worker already exists. Week number: " + weekNumber);
        }

        WorkWeekDto workWeekDto = workWeekMapper.toDto(workWeekRepository.save(WorkWeek
                .builder()
                .weekAvailability(new TreeMap<>())
                .weekNumber(weekNumber)
                .build()));
        barberDto.setWorkYears(
                barberDto.getWorkYears().stream()
                        .peek(workYear -> {
                            if (workYear.getYear().equals(year)) {
                                var yearSchedule = workYear.getYearSchedule();
                                yearSchedule.put(Math.toIntExact(weekNumber), workWeekDto);
                                workYear.setYearSchedule(yearSchedule);
                            }
                        }).collect(Collectors.toList())
        );

        return barberMapper.toDto(barberRepository.save(barberMapper.toEntity(barberDto)));
    }

    //TODO make it work
    @Override
    public BarberDto addWorkWeekToWorkYear(Long barberId, Long year, CreateWorkWeekDto createWorkWeekDto) {
        BarberDto barberDto = getBarberDto(barberId);

        if (!isWorkYearAbsent(year, barberDto)) {
            throw new UniqueValueException(String.format("year %d for this worker %d already exists", year, barberId));
        }

        var workWeekToSave = workWeekMapper.toNewEntity(createWorkWeekDto);

        workWeekToSave.getWeekAvailability().forEach((key, value) -> workDayRepository.save(value));
        WorkWeekDto updatedWorkWeek = workWeekMapper.toDto(workWeekRepository.save(workWeekToSave));

        barberDto.setWorkYears(
                barberDto.getWorkYears().stream()
                        .map(workYear -> {
                            if (workYear.getYear().equals(year)) {
                                var yearSchedule = workYear.getYearSchedule();
                                yearSchedule.put(Math.toIntExact(updatedWorkWeek.getWeekNumber()), updatedWorkWeek);
                                workYear.setYearSchedule(yearSchedule);
                            }
                            return workYear;
                        }).collect(Collectors.toList())
        );

        return barberMapper.toDto(barberRepository.save(barberMapper.toEntity(barberDto)));
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

    private static boolean isWorkWeekAbsent(Long newYear, BarberDto barberDto, Long weekNumber) {
        return barberDto.getWorkYears().stream()
                .filter(e -> e.getYear().equals(newYear))
                .noneMatch(e -> e.getYearSchedule().containsKey(Math.toIntExact(weekNumber)));
    }

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
