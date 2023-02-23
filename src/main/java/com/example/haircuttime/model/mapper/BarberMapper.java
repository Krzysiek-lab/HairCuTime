package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.availability.AvailabilityDto;
import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.barber.CreateBarberDto;
import com.example.haircuttime.model.dto.product.ProductDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.model.entity.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BarberMapper {
    private final WorkYearMapper workYearMapper;

    private final ProductMapper productMapper;

    private final AvailabilityMapper availabilityMapper;

    private final AbsenceMapper absenceMapper;

    public BarberMapper( WorkYearMapper workYearMapper, ProductMapper productMapper, AvailabilityMapper availabilityMapper, AbsenceMapper absenceMapper) {
        this.workYearMapper = workYearMapper;
        this.productMapper = productMapper;
        this.availabilityMapper = availabilityMapper;
        this.absenceMapper = absenceMapper;
    }

    public Barber toNewEntity(CreateBarberDto createBarberDto) {
        return Barber.builder()
                .name(createBarberDto.getName())
                .surname(createBarberDto.getSurname())
                .gender(createBarberDto.getGender())
                .products(new ArrayList<>())
                .workYears(new ArrayList<>())
                .availabilities(new ArrayList<>())
                .absences(new ArrayList<>())
                .build();
    }

    public Barber toEntity(BarberDto barberDto) {
        return Barber.builder()
                .id(barberDto.getId())
                .name(barberDto.getName())
                .surname(barberDto.getSurname())
                .gender(barberDto.getGender())
                .products(getProducts(barberDto))
                .workYears(getWorkYears(barberDto))
                .absences(getAbsences(barberDto))
                .availabilities(getAvailabilities(barberDto))
                .build();
    }

    public BarberDto toDto(Barber barber) {
        return BarberDto.builder()
                    .id(barber.getId())
                    .name(barber.getName())
                    .surname(barber.getSurname())
                    .gender(barber.getGender())
                    .products(getProductDto(barber))
                    .workYears(getWorkYearDto(barber))
                    .absences(getAbsenceDto(barber))
                    .availabilities(getAvailabilityDto(barber))
                    .build();
    }

    private List<WorkYear> getWorkYears(BarberDto barberDto) {
        return barberDto.getWorkYears()
                .stream()
                .map(workYearMapper::toEntity)
                .collect(Collectors.toList());
    }

    private List<WorkYearDto> getWorkYearDto(Barber barber) {
        return barber.getWorkYears()
                .stream()
                .map(workYearMapper::toDto)
                .collect(Collectors.toList());
    }

    private List<Product> getProducts(BarberDto barberDto) {
        return barberDto.getProducts()
                .stream()
                .map(productMapper::toEntity)
                .collect(Collectors.toList());
    }

    private List<ProductDto> getProductDto(Barber barber) {
        return barber.getProducts()
                .stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    private List<Absence> getAbsences(BarberDto barberDto) {
        return barberDto.getAbsences()
                .stream()
                .map(absenceMapper::toEntity)
                .collect(Collectors.toList());
    }

    private List<AbsenceDto> getAbsenceDto(Barber barber) {
        return barber.getAbsences()
                .stream()
                .map(absenceMapper::toDto)
                .collect(Collectors.toList());
    }

    private List<Availability> getAvailabilities(BarberDto barberDto) {
        return barberDto.getAvailabilities()
                .stream()
                .map(availabilityMapper::toEntity)
                .collect(Collectors.toList());
    }

    private List<AvailabilityDto> getAvailabilityDto(Barber barber) {
        return barber.getAvailabilities()
                .stream()
                .map(availabilityMapper::toDto)
                .collect(Collectors.toList());
    }
}
