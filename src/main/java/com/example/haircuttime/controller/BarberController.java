package com.example.haircuttime.controller;

import com.example.haircuttime.model.dto.barber.BarberDto;
import com.example.haircuttime.model.dto.barber.CreateBarberDto;
import com.example.haircuttime.model.entity.Barber;
import com.example.haircuttime.service.BarberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BarberController {

    private final BarberService barberService;

    @GetMapping("/barbers")
    public List<Barber>getAllBarbers(){
        return barberService.findAll();
    }
    @PostMapping("/barbers")
    public void createBarber(@RequestBody CreateBarberDto createBarberDto){
        barberService.save(createBarberDto);
    }
    @PutMapping("/barbers/{id}")
    public ResponseEntity<Barber>updateBarber(@PathVariable("id") long id, @RequestBody Barber barber){
        return  barberService.updateBarber(id, barber);
    }
    @DeleteMapping("/barbers/{id}")
    public ResponseEntity<String>deleteBarber(@PathVariable("id")long id){
        barberService.deleteBarber(id);
        return new ResponseEntity<String>("Barber was deleted.",HttpStatus.OK);
    }
}
