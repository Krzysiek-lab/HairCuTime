package com.example.haircuttime.service;

import com.example.haircuttime.exception.exceptions.ResourceNotFoundException;
import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.barber.CreateBarberDto;
import com.example.haircuttime.model.entity.Barber;
import com.example.haircuttime.model.mapper.BarberMapper;
import com.example.haircuttime.repository.BarberRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BarberService {

    private final BarberRepository barberRepository;
    private final BarberMapper barberMapper;

    public List<Barber> findAll() {
        return barberRepository.findAll();
    }

    public BarberDto save(CreateBarberDto barber) {
        return barberMapper.toDto(barberRepository.save(barberMapper.toNewEntity(barber)));
    }

    public ResponseEntity<Barber> updateBarber(long id, Barber barber) {
        Barber updateBarber = barberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barber with id: " + id + " doesn't exist!"));
        updateBarber.setName(barber.getName());
        updateBarber.setSurname(barber.getSurname());

        barberRepository.save(updateBarber);

        return ResponseEntity.ok(updateBarber);

    }


    public void deleteBarber(long id) {
        Barber deleteBarber = barberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barber with id: " + id + " doesn't exist!"));
        barberRepository.delete(deleteBarber);
    }
}
