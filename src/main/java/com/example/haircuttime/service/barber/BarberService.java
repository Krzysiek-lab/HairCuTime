package com.example.haircuttime.service.barber;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.barber.CreateBarberDto;
import com.example.haircuttime.model.entity.Barber;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BarberService {

    List<BarberDto> findAll();

    BarberDto save(CreateBarberDto createBarberDto);

    ResponseEntity<Barber> updateBarber(Long id, Barber barber);

    void deleteBarber(Long id);


}
