package com.example.haircuttime.service;

import com.example.haircuttime.exceptions.ResourceNotFoundException;
import com.example.haircuttime.model.Barbers;
import com.example.haircuttime.repository.BarbersRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BarbersService {

    private final BarbersRepository barbersRepository;

    public List<Barbers> findAll() {
        return barbersRepository.findAll();
    }

    public void save(Barbers barbers) {
        barbersRepository.save(barbers);
    }

    public ResponseEntity<Barbers> updateBarber(long id, Barbers barbers) {
        Barbers updateBarbers = barbersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barber with id: " + id + " doesn't exist!"));
        updateBarbers.setName(barbers.getName());
        updateBarbers.setSurname(barbers.getSurname());

        barbersRepository.save(updateBarbers);

        return ResponseEntity.ok(updateBarbers);

    }


    public void deleteBarber(long id) {
        Barbers deleteBarbers = barbersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barber with id: " + id + " doesn't exist!"));
        barbersRepository.delete(deleteBarbers);
    }
}
