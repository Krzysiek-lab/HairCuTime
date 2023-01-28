package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.entity.Barber;

public class BarberMapper {
    public static BarberDto toDTO(Barber barber) {
        return BarberDto.builder()
                .id(barber.getId())
                .name(barber.getName())
                .surname(barber.getSurname())
                .build();
    }

    public static Barber toEntity(BarberDto barberDTO) {
        return Barber.builder()
                .id(barberDTO.getId())
                .name(barberDTO.getName())
                .surname(barberDTO.getSurname())
                .build();
    }
}
