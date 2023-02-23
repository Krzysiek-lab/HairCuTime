package com.example.haircuttime.service.appointment;

import com.example.haircuttime.model.dto.appointment.AppointmentDto;
import com.example.haircuttime.model.dto.appointment.CreateAppointmentDto;
import com.example.haircuttime.model.dto.product.ProductDto;

import java.util.List;

public interface AppointmentService {

    List<AppointmentDto> getAllAppointment();

    AppointmentDto updateAppointment(CreateAppointmentDto appointmentDto,long id);

    AppointmentDto addAppointment(CreateAppointmentDto appointmentDto);

    void deleteAppointmentById(Long id);
}
