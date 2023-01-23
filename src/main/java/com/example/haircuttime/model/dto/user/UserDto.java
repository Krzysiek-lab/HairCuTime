package com.example.haircuttime.model.dto.user;

import com.example.haircuttime.model.entity.Role;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private List<Role> roles;

}
