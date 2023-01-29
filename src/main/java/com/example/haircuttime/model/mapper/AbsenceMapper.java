package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.absence.CreateAbsenceDto;
import com.example.haircuttime.model.entity.Absence;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AbsenceMapper {

    private final BarberMapper barberMapper;

    public Absence toEntity(AbsenceDto absenceDto) {
        return Absence.builder()
                .barber(barberMapper.toEntity(absenceDto.getBarberDto()))
                .workDay(absenceDto.getWorkDay())
                .absenceStart(absenceDto.getAbsenceStart())
                .absenceEnd(absenceDto.getAbsenceEnd())
                .build();
    }

    public AbsenceDto toDto(Absence absence) {
        return AbsenceDto.builder()
                .id(absence.getId())
                .workDay(absence.getWorkDay())
                .barberDto(barberMapper.toDTO(absence.getBarber()))
                .absenceStart(absence.getAbsenceStart())
                .absenceEnd(absence.getAbsenceEnd())
                .build();
    }

    public Absence toNewEntity(CreateAbsenceDto createAbsenceDto) {
        return Absence.builder()
                .id(0L)
                .workDay(createAbsenceDto.getWorkDay())
                .barber(barberMapper.toEntity(createAbsenceDto.getBarberDto()))
                .absenceStart(createAbsenceDto.getAbsenceStart())
                .absenceEnd(createAbsenceDto.getAbsenceEnd())
                .build();
    }
}
