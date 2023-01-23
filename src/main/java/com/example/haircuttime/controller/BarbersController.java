package com.example.haircuttime.controller;

import com.example.haircuttime.model.Barber;
import com.example.haircuttime.service.BarbersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BarbersController {

    private final BarbersService barbersService;

    @GetMapping("/barbers")
    public List<Barber>getAllBarbers(){
        return barbersService.findAll();
    }
    @PostMapping("/barbers")
    public void createBarber(@RequestBody Barber barber){
        barbersService.save(barber);
    }
    @PutMapping("/barbers/{id}")
    public ResponseEntity<Barber>updateBarber(@PathVariable("id") long id, @RequestBody Barber barber){
        return  barbersService.updateBarber(id,barber);
    }
    @DeleteMapping("/barbers/{id}")
    public ResponseEntity<String>deleteBarber(@PathVariable("id")long id){
        barbersService.deleteBarber(id);
        return new ResponseEntity<String>("Barber was deleted.",HttpStatus.OK);
    }
}
