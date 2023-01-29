package com.example.haircuttime.model.dto.user;

import com.example.haircuttime.model.entity.RoleEntity;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {

    private Long id;
    @Size(max = 64, message = "Size can't be bigger than 64 characters")
    @NotBlank(message = "Name is mandatory")
    private String name;
    @Size(max = 64, message = "Size can't be bigger than 64 characters")
    @NotBlank(message = "Surname is mandatory")
    private String surname;
    @Size(max = 64, message = "Size can't be bigger than 64 characters")
    @NotBlank(message = "Login is mandatory")
    private String login;
    @Size(min = 8,max = 20, message = "Size can't be less than 8 and no longer than 20 characters")
    @NotBlank(message = "Password is mandatory")
    private String password;
    @Size(max = 64, message = "Size can't be bigger than 64 characters")
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Please enter correct email address")
    private String email;
    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "^[0-9]{9}$",message = "Number is invalid")
    private String phoneNumber;

    private List<RoleEntity> roles;

   // private List<AppointmentCreateDto> createDtos;
}
