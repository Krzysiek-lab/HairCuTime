package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.absence.CreateAbsenceDto;
import com.example.haircuttime.model.entity.Absence;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class AbsenceMapper {

    private final BarberMapper barberMapper;

    private final WorkDayMapper workDayMapper;

    public AbsenceMapper(@Lazy BarberMapper barberMapper, @Lazy WorkDayMapper workDayMapper) {
        this.barberMapper = barberMapper;
        this.workDayMapper = workDayMapper;
    }

    public Absence toEntity(AbsenceDto absenceDto) {
        return Absence.builder()
                .barber(absenceDto.getBarber())
                .workDay(absenceDto.getWorkDay())
                .absenceStart(absenceDto.getAbsenceStart())
                .absenceEnd(absenceDto.getAbsenceEnd())
                .build();
    }

    public AbsenceDto toDto(Absence absence) {
        return AbsenceDto.builder()
                .id(absence.getId())
                .workDay(absence.getWorkDay())
                .barber(absence.getBarber())
                .absenceStart(absence.getAbsenceStart())
                .absenceEnd(absence.getAbsenceEnd())
                .build();
    }

    public Absence toNewEntity(CreateAbsenceDto createAbsenceDto) {
        return Absence.builder()
                .absenceStart(createAbsenceDto.getAbsenceStart())
                .absenceEnd(createAbsenceDto.getAbsenceEnd())
                .build();
    }
}
