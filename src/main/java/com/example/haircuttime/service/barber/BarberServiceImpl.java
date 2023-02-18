package com.example.haircuttime.service.barber;

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
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BarberServiceImpl implements BarberService{

    private final BarberRepository barberRepository;
    private final BarberMapper barberMapper;

    public List<BarberDto> findAll() {
        return barberRepository.findAll().stream()
                .map(barberMapper::toDto)
                .collect(Collectors.toList());
    }

    public BarberDto save(CreateBarberDto barber) {
        return barberMapper.toDto(barberRepository.save(barberMapper.toNewEntity(barber)));
    }

    public ResponseEntity<Barber> updateBarber(Long id, Barber barber) {
        Barber updateBarber = barberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barber with id: " + id + " doesn't exist!"));
        updateBarber.setName(barber.getName());
        updateBarber.setSurname(barber.getSurname());

        barberRepository.save(updateBarber);

        return ResponseEntity.ok(updateBarber);

    }


    public void deleteBarber(Long id) {
        Barber deleteBarber = barberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barber with id: " + id + " doesn't exist!"));
        barberRepository.delete(deleteBarber);
    }
}
