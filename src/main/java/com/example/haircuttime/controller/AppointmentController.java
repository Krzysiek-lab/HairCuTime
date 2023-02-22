package com.example.haircuttime.controller;

import com.example.haircuttime.model.dto.appointment.AppointmentDto;
import com.example.haircuttime.model.dto.appointment.CreateAppointmentDto;
import com.example.haircuttime.model.dto.product.ProductDto;
import com.example.haircuttime.model.entity.Appointment;
import com.example.haircuttime.model.mapper.AppointmentMapper;
import com.example.haircuttime.model.mapper.ProductMapper;
import com.example.haircuttime.repository.AppointmentRepository;
import com.example.haircuttime.repository.ProductRepository;
import com.example.haircuttime.service.appointment.AppointmentService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Data
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AppointmentController {


    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final AppointmentService appointmentService;


    @GetMapping("/allAppointments")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return new ResponseEntity<>(appointmentRepository.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAppointment")
    public ResponseEntity<String> deleteAppointment(@RequestParam long id) {
        appointmentRepository.deleteById(id);
        return new ResponseEntity<>("Appointment was deleted.", HttpStatus.OK);
    }


    @PutMapping("/updateAppointment")
    public ResponseEntity<Appointment> updateAppointment(@RequestParam long id, @RequestBody @Valid AppointmentDto appointmentDto) {
        return new ResponseEntity<>(appointmentService.updateAppointment(id, appointmentDto), HttpStatus.OK);
    }


    @PostMapping("/addAppointment")
    public void addAppointment(@RequestBody @Valid CreateAppointmentDto createAppointmentDto) {
        appointmentService.addAppointment(createAppointmentDto);
    }

    @PostMapping("/addNewProductToAnAppointment")
    public void addNewProductToAnAppointment(@RequestParam long id, @RequestBody @Valid ProductDto productDto) {
        appointmentService.addProductToAppointment(id, productDto);
    }


    @PostMapping("/addExistingProductToAnAppointment")
    public String addExistingProductToAnAppointment(@RequestParam long id, @RequestParam long serviceId) {
        appointmentService.addExistingProductToAppointment(id, serviceId);
        return "redirect:/allAppointments";
    }


}
