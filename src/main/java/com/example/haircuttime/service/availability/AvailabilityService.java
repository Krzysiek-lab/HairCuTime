package com.example.haircuttime.service.availability;

import com.example.haircuttime.model.dto.availability.AvailabilityDto;
import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.entity.WorkDay;

import java.util.List;

public interface AvailabilityService {

    AvailabilityDto createAvailability(WorkDay workDay);

    AvailabilityDto removeAvailability(Long id);

    List<AvailabilityDto> findAvailabilityByWorkDayId(Long workDayId);
    AvailabilityDto updateAvailability(AvailabilityDto availabilityDto);



    List<AvailabilityDto> findAvailabilityByBarberId(Long barberId);


}
