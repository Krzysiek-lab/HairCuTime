package com.example.haircuttime.model.dto.user;

import com.example.haircuttime.model.dto.appointment.AppointmentDto;
import com.example.haircuttime.model.entity.RoleEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    @Size(max = 64, message = "Size can't be bigger than 64 characters")
    @NotBlank(message = "Name is mandatory")
    private String name;
    @Size(max = 64, message = "Size can't be bigger than 64 characters")
    @NotBlank(message = "Surname is mandatory")
    private String surname;


    ///
    @Size(max = 64, message = "Size can't be bigger than 64 characters")
    @NotBlank(message = "Login is mandatory")
    private String login;

    @Size(max = 64, message = "Size can't be bigger than 64 characters")
    @NotBlank(message = "Password is mandatory")
    private String password;
    ///
    @Size(max = 64, message = "Size can't be bigger than 64 characters")
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Please enter correct email address")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "[0-9]{9}", message = "Please enter correct phone number")
    private String phoneNumber;
    private List<RoleEntity> roles;

    private List<AppointmentDto> appointments;
}
