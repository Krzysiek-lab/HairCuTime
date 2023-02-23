package com.example.haircuttime.controller;

import com.example.haircuttime.model.dto.user.CreateUserDto;
import com.example.haircuttime.model.dto.user.UserDto;
import com.example.haircuttime.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
@CrossOrigin
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public List<UserDto> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public UserDto saveUser(@RequestBody @Valid CreateUserDto createDto) {
        return userService.createUser(createDto);
    }

    @PutMapping("/update")
    public UserDto updateUser(@RequestBody @Valid UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }

}
