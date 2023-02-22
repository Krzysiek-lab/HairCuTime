package com.example.haircuttime.service.appointment;

import com.example.haircuttime.exception.exceptions.ResourceNotFoundException;
import com.example.haircuttime.model.dto.appointment.AppointmentDto;
import com.example.haircuttime.model.dto.appointment.CreateAppointmentDto;
import com.example.haircuttime.model.dto.product.ProductDto;
import com.example.haircuttime.model.entity.Appointment;
import com.example.haircuttime.model.entity.User;
import com.example.haircuttime.model.mapper.AppointmentMapper;
import com.example.haircuttime.model.mapper.ProductMapper;
import com.example.haircuttime.repository.AppointmentRepository;
import com.example.haircuttime.repository.ProductRepository;
import com.example.haircuttime.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentService implements AppointmentServiceRep {
    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepository appointmentRepository;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Appointment updateAppointment(long id, AppointmentDto appointmentDto) {
        var appointment = appointmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No element with given id"));
        appointment = appointmentMapper.toEntity(appointmentDto);
       return appointmentRepository.save(appointment);
    }


    public void addAppointment(CreateAppointmentDto appointmentDto) {
        Appointment appointment = appointmentMapper.toNewEntity(appointmentDto);
        appointment.setProduct(productRepository.findById(appointmentDto.getProductId())
                .orElseThrow(EntityExistsException::new));
        User user = userRepository.getReferenceById(appointmentDto.getUserId());
        //appointment.setUser(user);
        appointmentMapper.toDto(appointmentRepository.save(appointment));
       user.getAppointments().add(appointment);
       userRepository.save(user);
    }

    public void addProductToAppointment(long id, ProductDto productDto) {
        var appointment = appointmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No element with given id"));

        var product = productRepository.save(productMapper.toEntity((productDto)));
        appointment.setProduct(product);
        appointmentRepository.save(appointment);
    }


    public void addExistingProductToAppointment(long id, long serviceId) {
        if (productRepository.findById(serviceId).isPresent() && appointmentRepository.findById(id).isPresent()) {
            var appointment = appointmentRepository.findById(id).get();
            var service = productRepository.findById(serviceId).get();
            appointment.setProduct(service);
            appointmentRepository.save(appointment);
        } else {
            throw new ResourceNotFoundException("No element with given id");
        }
    }
}
