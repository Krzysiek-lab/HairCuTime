package com.example.haircuttime.service.appointment;

import com.example.haircuttime.model.dto.appointment.AppointmentDto;
import com.example.haircuttime.model.dto.appointment.CreateAppointmentDto;
import com.example.haircuttime.model.dto.product.ProductDto;

import java.util.List;

public interface AppointmentService {

    List<AppointmentDto> getAllAppointment();

    AppointmentDto updateAppointment(AppointmentDto appointmentDto);

    AppointmentDto addAppointment(CreateAppointmentDto appointmentDto);

    void addProductToAppointment(Long id, ProductDto productDto);

    void addExistingProductToAppointment(Long id, Long serviceId);

    void deleteAppointmentById(Long id);
}
