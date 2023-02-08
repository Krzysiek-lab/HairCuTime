package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.availability.AvailabilityDto;
import com.example.haircuttime.model.dto.availability.CreateAvailabilityDto;
import com.example.haircuttime.model.entity.Availability;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class AvailabilityMapper {

    public Availability toEntity(AvailabilityDto availabilityDto) {
        return Availability.builder()
                .id(availabilityDto.getId())
                .workDay(availabilityDto.getWorkDay())
                .startTime(availabilityDto.getStartTime())
                .endTime(availabilityDto.getEndTime())
                .build();
    }

    public Availability toNewEntity(CreateAvailabilityDto createAvailabilityDto) {
        return Availability.builder()
                .workDay(createAvailabilityDto.getWorkDay())
                .startTime(createAvailabilityDto.getWorkDay().getWorkDefinition().getStart())
                .endTime(createAvailabilityDto.getWorkDay().getWorkDefinition().getEnd())
                .build();
    }

    public AvailabilityDto toDto(Availability availability) {
        return AvailabilityDto.builder()
                .id(availability.getId())
                .workDay(availability.getWorkDay())
                .startTime(availability.getStartTime())
                .endTime(availability.getEndTime())
                .build();
    }
}
