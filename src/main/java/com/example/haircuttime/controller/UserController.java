package com.example.haircuttime.controller;

import com.example.haircuttime.model.dto.user.UserCreateDto;
import com.example.haircuttime.model.dto.user.UserDto;
import com.example.haircuttime.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public List<UserDto> getUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/add")
    public UserDto saveUser(@RequestBody @Valid UserCreateDto createDto){
        return userService.createUser(createDto);
    }
    @PutMapping("/update")
    public UserDto updateUser(@RequestBody @Valid UserDto userDto){
        return userService.updateUser(userDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUserById(id);
    }
}
