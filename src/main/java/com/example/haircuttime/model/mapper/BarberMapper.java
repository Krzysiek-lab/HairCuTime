package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.availability.AvailabilityDto;
import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.barber.CreateBarberDto;
import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.example.haircuttime.model.dto.workweek.WorkWeekDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.model.entity.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class BarberMapper {
    private final AbsenceMapper absenceMapper;
    private final AvailabilityMapper availabilityMapper;
    private final WorkYearMapper workYearMapper;
    private final WorkWeekMapper workWeekMapper;
    private final WorkDayMapper workDayMapper;

    public  Barber toNewEntity(CreateBarberDto createBarberDTO) {
        return Barber.builder()
                .id(createBarberDTO.getId())
                .name(createBarberDTO.getName())
                .surname(createBarberDTO.getSurname())
                .gender(createBarberDTO.getGender())
                .role(createBarberDTO.getRole())
                .products(new ArrayList<>())
                .absences(new ArrayList<>())
                .availabilityList(new ArrayList<>())
                .workYears(new ArrayList<>())
                .workWeeks(new ArrayList<>())
                .workDays(new ArrayList<>())
                .build();
    }

    public Barber toEntity(BarberDto barberDto) {
        return Barber.builder()
                .id(barberDto.getId())
                .name(barberDto.getName())
                .surname(barberDto.getSurname())
                .gender(barberDto.getGender())
                .role(barberDto.getRole())
                .products(barberDto.getProducts())
                .absences(getAbsences(barberDto))
                .availabilityList(getAvailabilityList(barberDto))
                .workYears(getWorkYears(barberDto))
                .workWeeks(getWorkWeeks(barberDto))
                .workDays(getWorkDays(barberDto))
                .build();
    }

    private List<Absence> getAbsences(BarberDto barberDto) {
        return barberDto.getAbsences()
                .stream()
                .map(absenceMapper::toEntity)
                .collect(Collectors.toList());
    }

    private List<Availability> getAvailabilityList(BarberDto barberDto) {
        return barberDto.getAvailabilityList()
                .stream()
                .map(availabilityMapper::toEntity)
                .collect(Collectors.toList());
    }

    private List<WorkYear> getWorkYears(BarberDto barberDto) {
        return barberDto.getWorkYears()
                .stream()
                .map(workYearMapper::toEntity)
                .collect(Collectors.toList());
    }

    private List<WorkWeek> getWorkWeeks(BarberDto barberDto) {
        return barberDto.getWorkWeeks()
                .stream()
                .map(workWeekMapper::toEntity)
                .collect(Collectors.toList());
    }

    private List<WorkDay> getWorkDays(BarberDto barberDto) {
        return barberDto.getWorkDays()
                .stream()
                .map(workDayMapper::toEntity)
                .collect(Collectors.toList());
    }

    public BarberDto toDto(Barber barber) {
        return BarberDto.builder()
                .id(barber.getId())
                .name(barber.getName())
                .surname(barber.getSurname())
                .gender(barber.getGender())
                .role(barber.getRole())
                .products(barber.getProducts())
                .absences(getAbsenceDtos(barber))
                .availabilityList(getAvailabilityDtos(barber))
                .workYears(getWorkYearDtos(barber))
                .workWeeks(getWorkWeekDtos(barber))
                .workDays(getWorkDayDtos(barber))
                .build();
    }

    private List<AbsenceDto> getAbsenceDtos(Barber barber) {
        return barber.getAbsences()
                .stream()
                .map(absenceMapper::toDto)
                .collect(Collectors.toList());
    }

    private List<AvailabilityDto> getAvailabilityDtos(Barber barber) {
        return barber.getAvailabilityList()
                .stream()
                .map(availabilityMapper::toDto)
                .collect(Collectors.toList());
    }

    private List<WorkYearDto> getWorkYearDtos(Barber barber) {
        return barber.getWorkYears()
                .stream()
                .map(workYearMapper::toDto)
                .collect(Collectors.toList());
    }

    private List<WorkWeekDto> getWorkWeekDtos(Barber barber) {
        return barber.getWorkWeeks()
                .stream()
                .map(workWeekMapper::toDto)
                .collect(Collectors.toList());
    }

    private List<WorkDayDto> getWorkDayDtos(Barber barber) {
        return barber.getWorkDays()
                .stream()
                .map(workDayMapper::toDto)
                .collect(Collectors.toList());
    }


}
