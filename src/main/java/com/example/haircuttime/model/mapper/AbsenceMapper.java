package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.absence.CreateAbsenceDto;
import com.example.haircuttime.model.entity.Absence;
import com.example.haircuttime.repository.AbsenceRepository;
import com.example.haircuttime.repository.BarberRepository;
import com.example.haircuttime.repository.WorkDayRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class AbsenceMapper {

    private final BarberMapper barberMapper;

    private final WorkDayMapper workDayMapper;
    private final WorkDayRepository workDayRepository;
    private final BarberRepository barberRepository;//dodane

    public AbsenceMapper(@Lazy BarberMapper barberMapper, @Lazy WorkDayMapper workDayMapper,
                         WorkDayRepository workDayRepository,
                         BarberRepository barberRepository,
                         AbsenceRepository absenceRepository) {
        this.barberMapper = barberMapper;
        this.workDayMapper = workDayMapper;
        this.workDayRepository = workDayRepository;
        this.barberRepository = barberRepository;
        this.absenceRepository = absenceRepository;
    }

    public Absence toEntity(AbsenceDto absenceDto) {
        return Absence.builder()
                //.barber(barberMapper.toEntity(absenceDto.getBarber()))
                //.workDay(workDayMapper.toEntity(absenceDto.getWorkDay()))
                .absenceStart(absenceDto.getAbsenceStart())
                .absenceEnd(absenceDto.getAbsenceEnd())
                .build();
    }

    public AbsenceDto toDto(Absence absence) {
        //
        if (yearId != 0 && barberId != 0) {
            var cc = workDayRepository.getReferenceById(yearId);
            cc.setAbsences(new ArrayList<>(List.of(absence)));
            cc = workDayRepository.save(cc);

            var bb = barberRepository.getReferenceById(barberId);
            bb.setAbsences(new ArrayList<>(List.of(absence)));
            bb = barberRepository.save(bb);

            absence.setBarber(bb);
            absence.setWorkDay(cc);
            absenceRepository.save(absence);

            return AbsenceDto.builder()
                    .id(absence.getId())
                    //.workDay(workDayMapper.toDto(workDayRepository.getReferenceById(yearId)))//zmienione
                    //.barber(barberMapper.toDto(barberRepository.getReferenceById(barberId)))//zmienione
                    .absenceStart(absence.getAbsenceStart())
                    .absenceEnd(absence.getAbsenceEnd())
                    .build();
        }
        //
        else {
            return AbsenceDto.builder()
                    .id(absence.getId())
                    //.workDay(workDayMapper.toDto(absence.getWorkDay()))//
                    //.barber(barberMapper.toDto(absence.getBarber()))//
                    .absenceStart(absence.getAbsenceStart())
                    .absenceEnd(absence.getAbsenceEnd())
                    .build();
        }
    }

    public Absence toNewEntity(CreateAbsenceDto createAbsenceDto) {
        return Absence.builder()
                .absenceStart(createAbsenceDto.getAbsenceStart())
                .absenceEnd(createAbsenceDto.getAbsenceEnd())
                .build();
    }

    private long barberId;
    private long yearId;
    private final AbsenceRepository absenceRepository;

    //dodane
    public void getBarberAndWorkYearIds(CreateAbsenceDto absenceDto) {
        Map<String, Long> map = Map.of("Barber", absenceDto.getBarberId(), "WorkYear", absenceDto.getWorkDayId());
        this.yearId = map.get("WorkYear");
        this.barberId = map.get("Barber");
    }
}
