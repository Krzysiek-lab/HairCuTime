package com.example.haircuttime.controller;

import com.example.haircuttime.model.dto.appointment.AppointmentDto;
import com.example.haircuttime.model.dto.appointment.CreateAppointmentDto;
import com.example.haircuttime.model.dto.product.ProductDto;
import com.example.haircuttime.model.mapper.AppointmentMapper;
import com.example.haircuttime.model.mapper.ProductMapper;
import com.example.haircuttime.repository.AppointmentRepository;
import com.example.haircuttime.repository.ProductRepository;
import com.example.haircuttime.service.appointment.AppointmentServiceImpl;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Getter
@RequiredArgsConstructor
@RequestMapping("appointment")
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController {


    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final AppointmentServiceImpl appointmentService;


    @GetMapping("/get")
    public List<AppointmentDto> getAllAppointments() {
        return appointmentService.getAllAppointment();
    }





    @DeleteMapping("/deleteAppointment")
    public ResponseEntity<String> deleteAppointment(@RequestParam long id) {
        appointmentRepository.deleteById(id);
        return new ResponseEntity<>("Appointment was deleted.", HttpStatus.OK);
    }


    @PostMapping("/create")
    public AppointmentDto addAppointment(@RequestBody @Valid CreateAppointmentDto createAppointmentDto) {
       return appointmentService.addAppointment(createAppointmentDto);
    }



    @PutMapping("/update")
    public AppointmentDto updateAppointment(@RequestBody @Valid AppointmentDto appointmentDto) {
        return appointmentService.updateAppointment(appointmentDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointmentById(id);
    }


    @PostMapping("/add-new-product")
    public String addNewProductToAnAppointment(@RequestParam long id, @RequestBody @Valid ProductDto productDto,
                                               BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            appointmentService.addProductToAppointment(id, productDto);
        }
        return "redirect:/allAppointments";
    }


    @PostMapping("/add-product")
    public String addExistingProductToAnAppointment(@RequestParam long id, @RequestParam long serviceId) {
        appointmentService.addExistingProductToAppointment(id, serviceId);
        return "redirect:/appointmentById" + id;
    }

}
