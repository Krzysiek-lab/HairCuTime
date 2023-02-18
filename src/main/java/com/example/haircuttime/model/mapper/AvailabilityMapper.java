package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.availability.AvailabilityDto;
import com.example.haircuttime.model.dto.availability.CreateAvailabilityDto;
import com.example.haircuttime.model.entity.Availability;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class AvailabilityMapper {

    private final BarberMapper barberMapper;

    private final WorkDayMapper workDayMapper;

    public AvailabilityMapper(@Lazy BarberMapper barberMapper, @Lazy WorkDayMapper workDayMapper) {
        this.barberMapper = barberMapper;
        this.workDayMapper = workDayMapper;
    }

    public Availability toEntity(AvailabilityDto availabilityDto) {
        return Availability.builder()
                .id(availabilityDto.getId())
                .barber(barberMapper.toEntity(availabilityDto.getBarber()))
                .workDay(workDayMapper.toEntity(availabilityDto.getWorkDay()))
                .startTime(availabilityDto.getStartTime())
                .endTime(availabilityDto.getEndTime())
                .build();
    }

    public Availability toNewEntity(CreateAvailabilityDto createAvailabilityDto) {
        return Availability.builder()
                .startTime(createAvailabilityDto.getStartTime())
                .endTime(createAvailabilityDto.getEndTime())
                .build();
    }

    public AvailabilityDto toDto(Availability availability) {
        return AvailabilityDto.builder()
                .id(availability.getId())
                .barber(barberMapper.toDto(availability.getBarber()))
                .workDay(workDayMapper.toDto(availability.getWorkDay()))
                .startTime(availability.getStartTime())
                .endTime(availability.getEndTime())
                .build();
    }
}
