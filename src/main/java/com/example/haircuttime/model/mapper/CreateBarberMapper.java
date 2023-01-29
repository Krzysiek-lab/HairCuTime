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
public class CreateBarberMapper {
    public Barber toNewEntity(CreateBarberDto createBarberDTO) {
        return Barber.builder()
                .id(createBarberDTO.getId())
                .name(createBarberDTO.getName())
                .surname(createBarberDTO.getSurname())
                .gender(createBarberDTO.getGender())
                .role(createBarberDTO.getRole())
                .products(new ArrayList<>())
                .workYears(new ArrayList<>())
                .build();
    }


}
