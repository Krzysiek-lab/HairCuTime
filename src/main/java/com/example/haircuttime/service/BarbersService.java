package com.example.haircuttime.service;

import com.example.haircuttime.exceptions.ResourceNotFoundException;
import com.example.haircuttime.model.Barber;
import com.example.haircuttime.repository.BarbersRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BarbersService {

    private final BarbersRepository barbersRepository;

    public List<Barber> findAll() {
        return barbersRepository.findAll();
    }

    public void save(Barber barber) {
        barbersRepository.save(barber);
    }

    public ResponseEntity<Barber> updateBarber(long id, Barber barber) {
        Barber updateBarber = barbersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barber with id: " + id + " doesn't exist!"));
        updateBarber.setName(barber.getName());
        updateBarber.setSurname(barber.getSurname());

        barbersRepository.save(updateBarber);

        return ResponseEntity.ok(updateBarber);

    }


    public void deleteBarber(long id) {
        Barber deleteBarber = barbersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barber with id: " + id + " doesn't exist!"));
        barbersRepository.delete(deleteBarber);
    }
}
