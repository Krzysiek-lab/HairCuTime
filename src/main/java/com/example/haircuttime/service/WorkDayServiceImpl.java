package com.example.haircuttime.service;

import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.absence.CreateAbsenceDto;
import com.example.haircuttime.model.dto.availability.AvailabilityDto;
import com.example.haircuttime.model.dto.workday.CreateWorkDayDto;
import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.example.haircuttime.model.mapper.AbsenceMapper;
import com.example.haircuttime.model.mapper.AvailabilityMapper;
import com.example.haircuttime.model.mapper.WorkDayMapper;
import com.example.haircuttime.repository.WorkDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class WorkDayServiceImpl implements WorkDayService {

    @Autowired
    private final WorkDayRepository workDayRepository;
    private final AvailabilityService availabilityService;
    private final AbsenceService absenceService;
    private final WorkDayMapper workDayMapper;
    private final AbsenceMapper absenceMapper;
    private final AvailabilityMapper availabilityMapper;

    @Override
    public WorkDayDto addWorkDay(CreateWorkDayDto createWorkDayDto) {
        return workDayMapper.toDto(workDayRepository.save(workDayMapper.toNewEntity(createWorkDayDto)));
    }

    @Override
    public WorkDayDto removeWorkDay(WorkDayDto workDayDto) {
        try {
            var toRemove = workDayRepository.getReferenceById(workDayDto.getId());
            workDayRepository.delete(toRemove);
            return workDayMapper.toDto(toRemove);

        } catch (NoSuchElementException e) {
            System.out.println("No such workday\n" + e);
            return null;
        }
    }

    @Override
    public WorkDayDto updateWorkDay(WorkDayDto workDayDto) {
        return workDayMapper.toDto(workDayRepository.save(workDayMapper.toEntity(workDayDto)));
    }

    @Override
    public List<AvailabilityDto> getAvailabilityByWorkDayId(Long workDayId) {
        return availabilityService.findAvailabilityByWorkDayId(workDayId);
    }

    @Override
    public List<AbsenceDto> getAbsencesByWorkDayId(Long workDayId) {
        return absenceService.getAbsenceByWorkDay(workDayId);
    }

    @Override
    public List<AbsenceDto> addAbsence(Long workDayId, CreateAbsenceDto createAbsenceDto) {
        absenceService.addAbsence(createAbsenceDto);
        var currentWorkDay = workDayRepository.getReferenceById(workDayId);

        var sortedAbsences = absenceService.getAbsenceByWorkDay(workDayId)
                .stream()
                .sorted(Comparator.comparing(AbsenceDto::getAbsenceStart))
                .toList();

        //TODO optional?
        LocalTime current = getAvailabilityByWorkDayId(workDayId)
                .stream()
                .min(Comparator.comparing(AvailabilityDto::getStartTime))
                .get().getStartTime();

        List<AvailabilityDto> newAvailabilityList = new ArrayList<>();

        for (AbsenceDto absence:sortedAbsences) {
            if (current.isBefore(absence.getAbsenceStart())) {
                newAvailabilityList.add(AvailabilityDto
                                .builder()
                                .workDay(absence.getWorkDay())
                                .barberId(absence.getBarberId())
                                .startTime(current)
                                .endTime(absence.getAbsenceStart())
                                .build());
            }
            current = absence.getAbsenceEnd();
            if (current.isBefore(absence.getWorkDay().getWorkDefinition().getEnd())){
                newAvailabilityList.add(AvailabilityDto
                        .builder()
                        .workDay(absence.getWorkDay())
                        .barberId(absence.getBarberId())
                        .startTime(current)
                        .endTime(absence.getWorkDay().getWorkDefinition().getEnd())
                        .build());
            }
        }

        getAvailabilityByWorkDayId(workDayId)
                .forEach(availabilityDto -> availabilityService.removeAvailability(availabilityDto.getId()));

        newAvailabilityList
                .forEach( availabilityDto -> availabilityService.createAvailability(currentWorkDay, availabilityDto.getId()));


        return getAbsencesByWorkDayId(workDayId);
    }

    @Override
    public List<AbsenceDto> removeAbsence(Long workDayId, CreateAbsenceDto createAbsenceDto) {
        return null;
    }

    @Override
    public List<AbsenceDto> removeAbsence(Long workDayId, AbsenceDto absenceDto) {
        absenceService.removeAbsence(absenceDto);
        var currentWorkDay = workDayRepository.getReferenceById(workDayId);

        var sortedAbsences = absenceService.getAbsenceByWorkDay(workDayId)
                .stream()
                .sorted(Comparator.comparing(AbsenceDto::getAbsenceStart))
                .toList();

        LocalTime current = currentWorkDay.getWorkDefinition().getStart();

        List<AvailabilityDto> newAvailabilityList = new ArrayList<>();

        for (AbsenceDto absence:sortedAbsences) {
            if (current.isBefore(absence.getAbsenceStart())) {
                newAvailabilityList.add(AvailabilityDto
                        .builder()
                        .workDay(absence.getWorkDay())
                        .barberId(absence.getBarberId())
                        .startTime(current)
                        .endTime(absence.getAbsenceStart())
                        .build());
            }
            current = absence.getAbsenceEnd();
            if (current.isBefore(absence.getWorkDay().getWorkDefinition().getEnd())){
                newAvailabilityList.add(AvailabilityDto
                        .builder()
                        .workDay(absence.getWorkDay())
                        .barberId(absence.getBarberId())
                        .startTime(current)
                        .endTime(absence.getWorkDay().getWorkDefinition().getEnd())
                        .build());
            }
        }

        getAvailabilityByWorkDayId(workDayId)
                .forEach(availabilityDto -> availabilityService.removeAvailability(availabilityDto.getId()));

        newAvailabilityList
                .forEach( availabilityDto -> availabilityService.createAvailability(currentWorkDay, availabilityDto.getId()));


        return getAbsencesByWorkDayId(workDayId);
    }


}
