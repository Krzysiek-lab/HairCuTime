package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.absence.CreateAbsenceDto;
import com.example.haircuttime.model.entity.Absence;
import org.springframework.stereotype.Component;

@Component
public class AbsenceMapper {

    public Absence toEntity(AbsenceDto absenceDto) {
        return Absence.builder()
                .barberId(absenceDto.getBarberId())
                .workDay(absenceDto.getWorkDay())
                .absenceStart(absenceDto.getAbsenceStart())
                .absenceEnd(absenceDto.getAbsenceEnd())
                .build();
    }

    public AbsenceDto toDto(Absence absence) {
        return AbsenceDto.builder()
                .id(absence.getId())
                .workDay(absence.getWorkDay())
                .barberId(absence.getBarberId())
                .absenceStart(absence.getAbsenceStart())
                .absenceEnd(absence.getAbsenceEnd())
                .build();
    }

    public Absence toNewEntity(CreateAbsenceDto createAbsenceDto) {
        return Absence.builder()
                .id(0L)
                .workDay(createAbsenceDto.getWorkDay())
                .barberId(createAbsenceDto.getBarberId())
                .absenceStart(createAbsenceDto.getAbsenceStart())
                .absenceEnd(createAbsenceDto.getAbsenceEnd())
                .build();
    }
}
