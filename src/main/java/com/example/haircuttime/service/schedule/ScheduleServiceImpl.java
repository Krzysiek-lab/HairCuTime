package com.example.haircuttime.service.schedule;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.workday.CreateWorkDayDto;
import com.example.haircuttime.model.dto.workyear.CreateWorkYearDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.model.entity.WorkDay;
import com.example.haircuttime.model.entity.WorkDefinition;
import com.example.haircuttime.model.mapper.BarberMapper;
import com.example.haircuttime.model.mapper.WorkDayMapper;
import com.example.haircuttime.model.mapper.WorkDefinitionMapper;
import com.example.haircuttime.model.mapper.WorkYearMapper;
import com.example.haircuttime.repository.BarberRepository;
import com.example.haircuttime.repository.WorkDayRepository;
import com.example.haircuttime.exception.exceptions.*;

import com.example.haircuttime.repository.WorkDefinitionRepository;
import com.example.haircuttime.repository.WorkYearRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final BarberRepository barberRepository;
    private final WorkDayRepository workDayRepository;
    private final WorkDefinitionRepository workDefinitionRepository;
    private final WorkYearRepository workYearRepository;
    private final BarberMapper barberMapper;
    private final WorkDayMapper workDayMapper;
    private final WorkYearMapper workYearMapper;
    private final WorkDefinitionMapper workDefinitionMapper;

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
    public BarberDto addWorkDay(Long barberId, Long year, Long dayInYear, String workDefinitionName) {

        //get workDefinition
        Optional<WorkDefinition> workDefinition = workDefinitionRepository.findByName(workDefinitionName);

        if (workDefinition.isEmpty()) {
            throw new UniqueValueException(String.format("No work definition named %s ", workDefinitionName));
        }

        //Get BarberDto
        BarberDto barberDto = getBarberDto(barberId);

        //get workYearDto
        WorkYearDto workYearDto = barberDto.getWorkYears()
                .stream()
                .filter(y -> y.getYear().equals(year))
                .findFirst()
                .orElseThrow(() -> new UniqueValueException(String.format("No year %d for this worker id %d", year, barberId)));

        //check if workday exists
        if (workYearDto.getWorkDayList()
                .stream()
                .filter(wd -> wd.getDayInYear().equals(dayInYear))
                .findAny().isEmpty()) {

            //create CreateWorkDay
            CreateWorkDayDto createWorkDayDto = CreateWorkDayDto.builder()
                    .workYear(workYearMapper.toEntity(workYearDto))
                    .dayInYear(dayInYear)
                    .workDefinition(workDefinition.get())
                    .build();


            WorkDay workDayBeforeSave = workDayMapper.toNewEntity(createWorkDayDto);
            WorkDay newWorkDay = workDayRepository.save(workDayBeforeSave);

            newWorkDay.getWorkYear().getWorkDayList().add(newWorkDay);
            var newWorkYear = newWorkDay.getWorkYear();
            var newerWorkYear = workYearRepository.save(newWorkYear);


            barberDto.getWorkYears().remove(workYearMapper.toDto(newWorkYear));
            //add the updated workYear back to the list
            barberDto.getWorkYears().set(Math.toIntExact(newerWorkYear.getId()-1),workYearMapper.toDto(newerWorkYear));
            //update work years

            //add to database and return
            return barberMapper.toDto(barberRepository.save(barberMapper.toEntity(barberDto)));
        }
        return null;
    }
    //WorkDay savedWorkDay = workDayRepository.save(workDay);
//WorkYear workYear = savedWorkDay.getWorkYear();
//workYear.getWorkDayList().remove(savedWorkDay);
//workYear.getWorkDayList().add(savedWorkDay);
//workYearRepository.save(workYear);


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
