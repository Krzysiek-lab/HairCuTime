package com.example.haircuttime.service.availability;

import com.example.haircuttime.model.dto.availability.AvailabilityDto;
import com.example.haircuttime.model.dto.availability.CreateAvailabilityDto;

import java.util.List;

public interface AvailabilityService {

    AvailabilityDto createAvailability(CreateAvailabilityDto createAvailabilityDto);

    AvailabilityDto removeAvailability(Long id);

    AvailabilityDto updateAvailability(AvailabilityDto availabilityDto);

    List<AvailabilityDto> findAvailabilityByWorkDayId(Long workDayId);

    List<AvailabilityDto> findAvailabilityByBarberId(Long barberId);


}
