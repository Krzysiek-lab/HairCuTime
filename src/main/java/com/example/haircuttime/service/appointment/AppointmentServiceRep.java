package com.example.haircuttime.service.appointment;

import com.example.haircuttime.model.dto.appointment.AppointmentDto;
import com.example.haircuttime.model.dto.appointment.CreateAppointmentDto;
import com.example.haircuttime.model.dto.product.ProductDto;
import com.example.haircuttime.model.entity.Appointment;

public interface AppointmentServiceRep {

    Appointment updateAppointment(long id, AppointmentDto appointmentDto);

    void addAppointment(CreateAppointmentDto appointmentDto);

    void addProductToAppointment(long id, ProductDto productDto);

    void addExistingProductToAppointment(long id, long serviceId);
}
