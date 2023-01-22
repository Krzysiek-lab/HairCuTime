package com.example.haircuttime.service;

import com.example.haircuttime.model.dto.availability.AvailabilityDto;
import com.example.haircuttime.model.dto.availability.CreateAvailabilityDto;
import com.example.haircuttime.model.mapper.AvailabilityMapper;
import com.example.haircuttime.model.schedule.Availability;
import com.example.haircuttime.model.schedule.WorkDay;
import com.example.haircuttime.repository.AvailabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AvailabilityServiceImpl implements AvailabilityService {
    @Autowired
    private final AvailabilityRepository availabilityRepository;
    private final AvailabilityMapper availabilityMapper;
    @Override
    public AvailabilityDto createAvailability(WorkDay workDay, Long barberId) {
        CreateAvailabilityDto createAvailabilityDto = CreateAvailabilityDto.builder()
                .barberId(barberId)
                .workDay(workDay).build();
        return availabilityMapper.toDto(availabilityRepository
                        .save(availabilityMapper.toNewEntity(createAvailabilityDto)));
    }

    @Override
    public AvailabilityDto removeAvailability(Long id) {
        Availability availabilityToRemove = availabilityRepository.getReferenceById(id);
        availabilityRepository.delete(availabilityToRemove);
        return availabilityMapper.toDto(availabilityToRemove);
    }

    @Override
    public AvailabilityDto updateAvailability(AvailabilityDto availabilityDto) {
        Availability toUpdate = availabilityRepository.getReferenceById(availabilityDto.getId());
        try {
            availabilityRepository.save(toUpdate);
        }catch (NoSuchElementException e){
            System.out.println("No such availability :\n" + e);
        }
        return availabilityMapper.toDto(toUpdate);
    }

    @Override
    public List<AvailabilityDto> findAvailabilityByWorkDayId(Long workDayId) {
        return availabilityRepository
                .findAvailabilitiesByWorkDay_Id(workDayId)
                .stream()
                .map(availabilityMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AvailabilityDto> findAvailabilityByBarberId(Long barberId) {
        return availabilityRepository
                .findAvailabilitiesByWorkDay_Id(barberId)
                .stream()
                .map(availabilityMapper::toDto)
                .collect(Collectors.toList());
    }


}
