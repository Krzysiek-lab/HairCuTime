package com.example.haircuttime.service.absence;

import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.absence.CreateAbsenceDto;
import com.example.haircuttime.model.entity.Absence;
import com.example.haircuttime.model.mapper.AbsenceMapper;
import com.example.haircuttime.model.mapper.BarberMapper;
import com.example.haircuttime.model.mapper.WorkDayMapper;
import com.example.haircuttime.repository.AbsenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AbsenceServiceImpl implements AbsenceService {
    private final AbsenceRepository absenceRepository;
    private final AbsenceMapper absenceMapper;
    private final BarberMapper barberMapper;
    private final WorkDayMapper workDayMapper;

    @Override
    public AbsenceDto getAbsenceById(Long id) {
        return absenceMapper.toDto(absenceRepository.getReferenceById(id));
    }

    @Override
    public List<AbsenceDto> getAbsenceByBarber(Long barberId) {
        return absenceRepository.findAbsencesByBarberId(barberId)
                .stream()
                .map(absenceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AbsenceDto> getAbsenceByWorkDay(Long workDayId) {
        return absenceRepository.findAbsencesByWorkDay_Id(workDayId)
                .stream()
                .map(absenceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AbsenceDto addAbsence(CreateAbsenceDto createAbsenceDto) {
        return absenceMapper.toDto(absenceRepository
                .save(absenceMapper.toNewEntity(createAbsenceDto)));
    }

    @Override
    public Boolean removeAbsence(Long id) {
        Optional<Absence> absence = absenceRepository.findById(id);
        if (absence.isPresent()) {
            absenceRepository.delete(absence.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<AbsenceDto> sortAbsences() {
        return absenceRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Absence::getAbsenceStart))
                .map(absenceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateAbsence(Long id, AbsenceDto absence) {
        absenceRepository.findById(id).ifPresent(e -> {
            var abs = Absence.builder()
                    .barber(absence.getBarber())
                    .absenceStart(absence.getAbsenceStart())
                    .absenceEnd(absence.getAbsenceEnd())
                    .workDay(absence.getWorkDay())
                    .build();
            absenceRepository.save(abs);
        });
    }
}
