package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.appointment.AppointmentDto;
import com.example.haircuttime.model.dto.user.CreateUserDto;
import com.example.haircuttime.model.dto.user.UserDto;
import com.example.haircuttime.model.entity.Appointment;
import com.example.haircuttime.model.entity.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

      private final AppointmentMapper appointmentMapper;

    public UserMapper( @Lazy AppointmentMapper appointmentMapper) {
        this.appointmentMapper = appointmentMapper;
    }

    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .roles(user.getRoles())
                .appointments(getAppointmentsDto(user))
                .build();
    }
    public User toEntity(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .login(userDto.getEmail())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .phoneNumber(userDto.getPhoneNumber())
                .email(userDto.getEmail())
                .appointments(getAppointments(userDto))
                .build();
    }
    public User toNewEntity(CreateUserDto createDto) {
        return User.builder()
                .login(createDto.getLogin())
                .name(createDto.getName())
                .surname(createDto.getSurname())
                .email(createDto.getEmail()).
                phoneNumber(createDto.getPhoneNumber())
                .build();
    }

   private List<AppointmentDto> getAppointmentsDto(User user) {
        return user.getAppointments().stream()
                .map(appointmentMapper::toDto)
                .collect(Collectors.toList());
    }
    private List<Appointment> getAppointments(UserDto userDto){
        return userDto.getAppointments().stream()
                .map(appointmentMapper::toEntity)
                .collect(Collectors.toList());
    }
}
