package com.example.haircuttime.service.appointment;

import com.example.haircuttime.exception.exceptions.ResourceNotFoundException;
import com.example.haircuttime.model.dto.appointment.AppointmentDto;
import com.example.haircuttime.model.dto.product.ProductDto;
import com.example.haircuttime.model.mapper.AppointmentMapper;
import com.example.haircuttime.model.mapper.ProductMapper;
import com.example.haircuttime.repository.AppointmentRepository;
import com.example.haircuttime.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentService implements AppointmentServiceRep {
    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepository appointmentRepository;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public void updateAppointment(long id, AppointmentDto appointmentDto) {
        var appointment = appointmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No element with given id"));
        appointment = appointmentMapper.mapper(appointmentDto);
        appointmentRepository.save(appointment);
    }


    public void addAppointment(AppointmentDto appointmentDto) {
        var appointment = appointmentMapper.mapper(appointmentDto);
        appointmentRepository.save(appointment);
    }

    public void addProductToAppointment(long id, ProductDto productDto) {
        var appointment = appointmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No element with given id"));

        var product = productRepository.save(productMapper.mapper((productDto)));
        appointment.setProduct(product);
        appointmentRepository.save(appointment);
    }


    public void addExistingProductToAppointment(long id, long serviceId) {
        if (productRepository.findById(serviceId).isPresent() && appointmentRepository.findById(id).isPresent()) {
            var appointment = appointmentRepository.findById(id).get();
            var service = productRepository.findById(serviceId).get();
            appointment.setProduct(service);
            service.getAppointments().add(appointment);
            appointmentRepository.save(appointment);
        } else {
            throw new ResourceNotFoundException("No element with given id");
        }
    }
}
