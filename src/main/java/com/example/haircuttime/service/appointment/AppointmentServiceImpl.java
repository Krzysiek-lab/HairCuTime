package com.example.haircuttime.service.appointment;

import com.example.haircuttime.exception.exceptions.ResourceNotFoundException;
import com.example.haircuttime.model.dto.appointment.AppointmentDto;
import com.example.haircuttime.model.dto.appointment.CreateAppointmentDto;
import com.example.haircuttime.model.dto.product.ProductDto;
import com.example.haircuttime.model.entity.Appointment;
import com.example.haircuttime.model.entity.Product;
import com.example.haircuttime.model.mapper.AppointmentMapper;
import com.example.haircuttime.model.mapper.ProductMapper;
import com.example.haircuttime.repository.AppointmentRepository;
import com.example.haircuttime.repository.ProductRepository;
import com.example.haircuttime.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepository appointmentRepository;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public List<AppointmentDto> getAllAppointment() {
        return appointmentRepository.findAll().stream()
                .map(appointmentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDto addAppointment(CreateAppointmentDto createDto) {
        Appointment appointment = appointmentMapper.toNewEntity(createDto);
        var product = productRepository.findById(createDto.getProductId())
                .orElseThrow(EntityNotFoundException::new);
        appointment.setUser(userRepository.findById(createDto.getUserId())
                .orElseThrow(EntityExistsException::new));

        appointment.setServiceLength(product.getProductDuration());
        appointment.setProduct(product);
        return appointmentMapper.toDto(appointmentRepository.save(appointment));
    }

    @Override
    public AppointmentDto updateAppointment(AppointmentDto appointmentDto) {
        return appointmentRepository.findById(appointmentDto.getId()).map(appointment -> {
            appointment.setProduct(productRepository.findById(appointmentDto.getProduct().getId())
                    .orElseThrow(EntityNotFoundException::new));
            appointment.setServiceLength(productRepository.findById(appointmentDto.getProduct().getId())
                    .map(Product::getProductDuration).orElseThrow(EntityNotFoundException::new));
            return appointmentMapper.toDto(appointment);
        }).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void addProductToAppointment(Long id, ProductDto productDto) {
        var appointment = appointmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No element with given id"));

        var product = productRepository.save(productMapper.toEntity((productDto)));
        appointment.setProduct(product);
        appointmentRepository.save(appointment);
    }

    @Override
    public void addExistingProductToAppointment(Long id, Long serviceId) {
        if (productRepository.findById(serviceId).isPresent() && appointmentRepository.findById(id).isPresent()) {
            var appointment = appointmentRepository.findById(id).get();
            var service = productRepository.findById(serviceId).get();
            appointment.setProduct(service);
            appointmentRepository.save(appointment);
        } else {
            throw new ResourceNotFoundException("No element with given id");
        }
    }

    @Override
    public void deleteAppointmentById(Long id) {
        appointmentRepository.deleteById(id);
    }
}
