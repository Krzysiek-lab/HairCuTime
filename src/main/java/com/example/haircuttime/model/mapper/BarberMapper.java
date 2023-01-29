package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.entity.Barber;
import org.springframework.stereotype.Component;

@Component
public class BarberMapper {
    public  BarberDto toDTO(Barber barber) {
        return BarberDto.builder()
                .id(barber.getId())
                .name(barber.getName())
                .surname(barber.getSurname())
                .build();
    }

    public  Barber toEntity(BarberDto barberDTO) {
        return Barber.builder()
                .id(barberDTO.getId())
                .name(barberDTO.getName())
                .surname(barberDTO.getSurname())
                .build();
    }
}
