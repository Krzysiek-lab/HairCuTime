package com.example.haircuttime.controller;

import com.example.haircuttime.dto.AppointmentDto;
import com.example.haircuttime.exception.NoElementException;
import com.example.haircuttime.mapper.AppointmentMapper;
import com.example.haircuttime.model.Appointment;
import com.example.haircuttime.repository.AppointmentRepository;
import com.example.haircuttime.repository.ServicesRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Data
@Controller
public class AppointmentController {


    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final ServicesRepository servicesRepository;


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
    public String updateAppointment(@RequestParam long id, @RequestBody AppointmentDto appointmentDto) {
        var appointment = appointmentRepository.findById(id).orElseThrow(() ->
                new NoElementException("No element with given id"));
        appointment = appointmentMapper.mapper(appointmentDto);
        appointmentRepository.save(appointment);
        return "redirect:/allAppointments";
    }


    @PostMapping("/addAppointment")
    public String addAppointment(@RequestBody AppointmentDto appointmentDto) {
        var appointment = appointmentMapper.mapper(appointmentDto);
        appointmentRepository.save(appointment);
        return "redirect:/allAppointments";
    }


//    @PostMapping("/addNewServiceToAnAppointment") // DOPOKI NIE MA SERVICE ENCJI
//    public String addNewServiceToAnAppointment(@RequestParam long id, @RequestBody ServicesDto servicesDto) {
//        var appointment = appointmentRepository.findById(id).orElseThrow(() ->
//                new NoElementException("No element with given id"));
//
//        var service = servicesRepository.save(servicesMapper.mapper((servicesDto)));
//        appointment.setServices(service);
//        appointmentRepository.save(appointment);
//        return "redirect:/allAppointments";
//    }


    @PostMapping("/addExistingServiceToAnAppointment")
    public String addExistingServiceToAnAppointment(@RequestParam long id, @RequestParam long serviceId) {

        if (servicesRepository.findById(serviceId).isPresent() && appointmentRepository.findById(id).isPresent()) {
            var appointment = appointmentRepository.findById(id).get();
            var service = servicesRepository.findById(serviceId).get();
            appointment.setServices(service);
            service.getAppointments().add(appointment);
            appointmentRepository.save(appointment);
        } else {
            throw new NoElementException("No element with given id");
        }
        return "redirect:/allAppointments";
    }


}
