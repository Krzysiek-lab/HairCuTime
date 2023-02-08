package com.example.haircuttime.controller;

import com.example.haircuttime.exception.exceptions.ResourceNotFoundException;
import com.example.haircuttime.model.dto.appointment.AppointmentDto;
import com.example.haircuttime.model.dto.product.ProductDto;
import com.example.haircuttime.model.entity.Appointment;
import com.example.haircuttime.model.mapper.AppointmentMapper;
import com.example.haircuttime.model.mapper.ProductMapper;
import com.example.haircuttime.repository.AppointmentRepository;
import com.example.haircuttime.repository.ProductRepository;
import com.example.haircuttime.service.AppointmentService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Data
@CrossOrigin(origins = "http://localhost:3000")
@Controller
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
    public String deleteAppointment(@RequestParam long id) {
        appointmentRepository.deleteById(id);
        return "redirect:/allAppointments";
    }


    @PutMapping("/updateAppointment")
    public String updateAppointment(@RequestParam long id, @RequestBody @Valid AppointmentDto appointmentDto,
                                    BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            appointmentService.updateAppointment(id, appointmentDto);
        }
        return "redirect:/allAppointments";
    }


    @PostMapping("/addAppointment")
    public String addAppointment(@RequestBody @Valid AppointmentDto appointmentDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            appointmentService.addAppointment(appointmentDto);
        }
        return "redirect:/allAppointments";
    }

    @PostMapping("/addNewProductToAnAppointment")
    public String addNewProductToAnAppointment(@RequestParam long id, @RequestBody @Valid ProductDto productDto,
                                               BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            appointmentService.addProductToAppointment(id, productDto);
        }
        return "redirect:/allAppointments";
    }


    @PostMapping("/addExistingProductToAnAppointment")
    public String addExistingProductToAnAppointment(@RequestParam long id, @RequestParam long serviceId) {
        appointmentService.addExistingProductToAppointment(id, serviceId);
        return "redirect:/allAppointments";
    }


}
