package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.barber.CreateBarberDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.model.entity.Barber;
import com.example.haircuttime.model.entity.WorkYear;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BarberMapper {
    private final WorkYearMapper workYearMapper;
//    public Barber toNewEntity(CreateBarberDto createBarberDTO) {
//        return Barber.builder()
//                .id(createBarberDTO.getId())
//                .name(createBarberDTO.getName())
//                .surname(createBarberDTO.getSurname())
//                .gender(createBarberDTO.getGender())
//                .role(createBarberDTO.getRole())
//                .products(new ArrayList<>())
//                .workYears(new ArrayList<>())
//                .build();
//    }

    public Barber toEntity(BarberDto barberDto) {
        return Barber.builder()
                .id(barberDto.getId())
                .name(barberDto.getName())
                .surname(barberDto.getSurname())
                .gender(barberDto.getGender())
                .role(barberDto.getRole())
                .products(barberDto.getProducts())
                .workYears(getWorkYears(barberDto))
                .build();
    }

    private List<WorkYear> getWorkYears(BarberDto barberDto) {
        return barberDto.getWorkYears()
                .stream()
                .map(workYearMapper::toEntity)
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
                .workYears(getWorkYearDtos(barber))
                .build();
    }

    private List<WorkYearDto> getWorkYearDtos(Barber barber) {
        return barber.getWorkYears()
                .stream()
                .map(workYearMapper::toDto)
                .collect(Collectors.toList());
    }


}
