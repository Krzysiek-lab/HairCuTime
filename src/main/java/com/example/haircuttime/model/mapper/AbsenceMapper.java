package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.absence.CreateAbsenceDto;
import com.example.haircuttime.model.entity.Absence;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class AbsenceMapper {


    public Absence toEntity(AbsenceDto absenceDto) {
        return Absence.builder()
                .id(absenceDto.getId())
                .workDay(absenceDto.getWorkDay())
                .absenceStart(absenceDto.getAbsenceStart())
                .absenceEnd(absenceDto.getAbsenceEnd())
                .build();
    }

    public AbsenceDto toDto(Absence absence) {
        return AbsenceDto.builder()
                .id(absence.getId())
                .workDay(absence.getWorkDay())
                .absenceStart(absence.getAbsenceStart())
                .absenceEnd(absence.getAbsenceEnd())
                .build();
    }

    public Absence toNewEntity(CreateAbsenceDto createAbsenceDto) {
        return Absence.builder()
                .workDay(createAbsenceDto.getWorkDay())
                .absenceStart(createAbsenceDto.getAbsenceStart())
                .absenceEnd(createAbsenceDto.getAbsenceEnd())
                .build();
    }
}
