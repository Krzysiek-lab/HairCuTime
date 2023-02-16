package com.example.haircuttime.service.appointment;

import com.example.haircuttime.model.dto.appointment.AppointmentDto;
import com.example.haircuttime.model.dto.product.ProductDto;

public interface AppointmentServiceRep {

    void updateAppointment(long id, AppointmentDto appointmentDto);

    void addAppointment(AppointmentDto appointmentDto);

    void addProductToAppointment(long id, ProductDto productDto);

    void addExistingProductToAppointment(long id, long serviceId);
}
