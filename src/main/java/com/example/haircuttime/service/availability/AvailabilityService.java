package com.example.haircuttime.service.availability;

import com.example.haircuttime.model.dto.availability.AvailabilityDto;
import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.barber.CreateBarberDto;
import com.example.haircuttime.model.entity.WorkDay;

import java.util.List;

public interface AvailabilityService {

    AvailabilityDto createAvailability(WorkDay workDay, BarberDto barberDto);

    AvailabilityDto removeAvailability(Long id);

    AvailabilityDto updateAvailability(AvailabilityDto availabilityDto);

    List<AvailabilityDto> findAvailabilityByWorkDayId(Long workDayId);

    List<AvailabilityDto> findAvailabilityByBarberId(Long barberId);


}
