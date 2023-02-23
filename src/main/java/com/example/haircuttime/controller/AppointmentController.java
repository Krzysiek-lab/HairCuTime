package com.example.haircuttime.controller;

import com.example.haircuttime.exception.exceptions.ResourceNotFoundException;
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
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Setter
@Getter
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("appointment")
public class AppointmentController {


    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final AppointmentService appointmentService;


    @GetMapping("/get")
    public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
        return new ResponseEntity<>(appointmentService.getAllAppointment(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable long id) {
        appointmentService.deleteAppointmentById(id);
        return new ResponseEntity<>("Appointment was deleted.", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<AppointmentDto> updateAppointment(@RequestBody @Valid AppointmentDto appointmentDto) {
        return new ResponseEntity<>(appointmentService.updateAppointment(appointmentDto), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<AppointmentDto> addAppointment(@RequestBody @Valid CreateAppointmentDto createAppointmentDto) {
        return new ResponseEntity<>(appointmentService.addAppointment(createAppointmentDto), HttpStatus.OK);
    }

    @PostMapping("/newProduct")
    public void addNewProductToAnAppointment(@RequestParam long id, @RequestBody @Valid ProductDto productDto) {
        appointmentService.addProductToAppointment(id, productDto);
    }

    @PostMapping("/existingProduct")
    public String addExistingProductToAnAppointment(@RequestParam long id, @RequestParam long serviceId) {
        appointmentService.addExistingProductToAppointment(id, serviceId);
        return "redirect:/appointmentById" + id;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Appointment> appointmentById(@PathVariable long id) {
        return new ResponseEntity<>(appointmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No such appointment")), HttpStatus.OK);
    }
}
