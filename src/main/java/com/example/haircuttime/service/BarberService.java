package com.example.haircuttime.service;

import com.example.haircuttime.exception.exceptions.ResourceNotFoundException;
import com.example.haircuttime.model.entity.Barber;
import com.example.haircuttime.repository.BarberRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BarberService {

    private final BarberRepository barberRepository;

    public List<Barber> findAll() {
        return barberRepository.findAll();
    }

    public void save(Barber barber) {
        barberRepository.save(barber);
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
