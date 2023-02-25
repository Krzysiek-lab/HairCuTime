package com.example.haircuttime.controller;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.barber.CreateBarberDto;
import com.example.haircuttime.model.entity.Barber;
import com.example.haircuttime.repository.BarberRepository;
import com.example.haircuttime.service.barber.BarberServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("barber")
@CrossOrigin(origins = "http://localhost:3000")
public class BarberController {

    private final BarberServiceImpl barberService;
    private final BarberRepository barberRepository;

    @GetMapping("/get")
    public List<BarberDto> getAllBarbers() {
        return barberService.findAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Barber>> getBarberById(@PathVariable("id") long id) {
        return new ResponseEntity<>(barberRepository.findById(id),HttpStatus.OK);
    }

    @PostMapping("/create")
    public BarberDto createBarber(@RequestBody @Valid CreateBarberDto barber) {
        return barberService.save(barber);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Barber> updateBarber(@PathVariable("id") long id, @RequestBody @Valid Barber barber) {
        return barberService.updateBarber(id, barber);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBarber(@PathVariable("id") long id) {
        barberService.deleteBarber(id);
        return new ResponseEntity<>("Barber was deleted.", HttpStatus.OK);
    }

    @PostMapping("/add-product/{id}")
    public BarberDto addProduct(@RequestBody BarberDto barberDto, @PathVariable Long id) {
        return barberService.addProductToBarber(barberDto, id);
    }

    @PostMapping("/remove-product/{id}")
    public BarberDto removeProduct(@RequestBody BarberDto barberDto, @PathVariable Long id) {
        return barberService.removeProductFromBarber(barberDto, id);
    }
}
