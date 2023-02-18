package com.example.haircuttime.controller;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.barber.CreateBarberDto;
import com.example.haircuttime.model.entity.Barber;
import com.example.haircuttime.service.barber.BarberServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")

public class BarberController {

    private final BarberServiceImpl barberService;

    @GetMapping("/barbers")
    public List<BarberDto> getAllBarbers() {
        return barberService.findAll();
    }

    @PostMapping("/barbers")
    public BarberDto createBarber(@RequestBody CreateBarberDto barber) {
        return barberService.save(barber);
    }

    @PutMapping("/barbers/{id}")
    public ResponseEntity<Barber> updateBarber(@PathVariable("id") long id, @RequestBody Barber barber) {
        return barberService.updateBarber(id, barber);
    }

    @DeleteMapping("/barbers/{id}")
    public ResponseEntity<String> deleteBarber(@PathVariable("id") long id) {
        barberService.deleteBarber(id);
        return new ResponseEntity<String>("Barber was deleted.", HttpStatus.OK);
    }
}
