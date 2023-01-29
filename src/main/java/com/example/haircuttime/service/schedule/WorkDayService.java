package com.example.haircuttime.service.schedule;

import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.absence.CreateAbsenceDto;
import com.example.haircuttime.model.dto.availability.AvailabilityDto;
import com.example.haircuttime.model.dto.workday.CreateWorkDayDto;
import com.example.haircuttime.model.dto.workday.WorkDayDto;

import java.util.List;

public interface WorkDayService {

    WorkDayDto addWorkDay(CreateWorkDayDto createWorkDayDto);

    WorkDayDto removeWorkDay(WorkDayDto workDayDto);

    WorkDayDto updateWorkDay(WorkDayDto workDayDto);

    List<AvailabilityDto> getAvailabilityByWorkDayId(Long workDayId);

    List<AbsenceDto> getAbsencesByWorkDayId(Long workDayId);

    List<AbsenceDto> addAbsence(Long workDayId, CreateAbsenceDto createAbsenceDto);

    List<AbsenceDto> removeAbsence(Long workDayId, CreateAbsenceDto createAbsenceDto);

    List<AbsenceDto> removeAbsence(Long workDayId, AbsenceDto absenceDto);
}
