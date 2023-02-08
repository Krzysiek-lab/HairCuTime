package com.example.haircuttime.service.absence;

import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.absence.CreateAbsenceDto;

import java.util.List;

public interface AbsenceService {
    AbsenceDto getAbsenceById(Long id);

    List<AbsenceDto> getAbsenceByBarber(Long barberId);

    List<AbsenceDto> getAbsenceByWorkDay(Long workDayId);

    AbsenceDto addAbsence(CreateAbsenceDto createAbsenceDto);

    Boolean removeAbsence(AbsenceDto absenceDto);

    List<AbsenceDto> sortAbsences();
}
