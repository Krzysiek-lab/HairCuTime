package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.availability.AvailabilityDto;
import com.example.haircuttime.model.dto.availability.CreateAvailabilityDto;
import com.example.haircuttime.model.entity.Availability;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AvailabilityMapper {

    private final BarberMapper barberMapper;

    public Availability toEntity(AvailabilityDto availabilityDto) {
        return Availability.builder()
                .id(0L)
                .barber(barberMapper.toEntity(availabilityDto.getBarberDto()))
                .workDay(availabilityDto.getWorkDay())
                .startTime(availabilityDto.getStartTime())
                .endTime(availabilityDto.getEndTime())
                .build();
    }

    public Availability toNewEntity(CreateAvailabilityDto createAvailabilityDto) {
        return Availability.builder()
                .id(0L)
                .barber(barberMapper.toEntity(createAvailabilityDto.getBarberDto()))
                .workDay(createAvailabilityDto.getWorkDay())
                .startTime(createAvailabilityDto.getWorkDay().getWorkDefinition().getStart())
                .endTime(createAvailabilityDto.getWorkDay().getWorkDefinition().getEnd())
                .build();
    }

    public AvailabilityDto toDto(Availability availability) {
        return AvailabilityDto.builder()
                .id(availability.getId())
                .barberDto(barberMapper.toDto(availability.getBarber()))
                .workDay(availability.getWorkDay())
                .startTime(availability.getStartTime())
                .endTime(availability.getEndTime())
                .build();
    }
}
