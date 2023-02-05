package com.example.haircuttime.service.user;

import com.example.haircuttime.exception.exceptions.UniqueValueException;
import com.example.haircuttime.exception.messages.ExceptionMessages;
import com.example.haircuttime.model.dto.user.UserCreateDto;
import com.example.haircuttime.model.dto.user.UserDto;
import com.example.haircuttime.model.entity.RoleEntity;
import com.example.haircuttime.model.entity.User;
import com.example.haircuttime.model.enums.Role;
import com.example.haircuttime.model.mapper.UserMapper;
import com.example.haircuttime.repository.RoleEntityRepository;
import com.example.haircuttime.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleEntityRepository roleRepository;
    private static final String USER_NOT_FOUND = "user with login not found";


    private final UserMapper userMapper;


    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    // MOZE LEPIEJ BEDZIE UZYC REPOSITORYEVENTHANDLER'A???
    public UserDto createUser(UserCreateDto createDto) {
        User user = userMapper.toNewEntity(createDto);
        if (roleRepository.existsByName(Role.USER)) {
            user.setRoles(List.of(roleRepository.findByName(Role.USER)));
        } else {
            user.setRoles(List.of(RoleEntity.builder().name(Role.USER).build()));
            //CZY NIETRZEBA ZAPISAC DO REPOZYTORIUM NJPIERW???
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UniqueValueException(ExceptionMessages.EMAIL_IS_ALREADY_EXIST.getMessage());
        } else if (userRepository.existsByLogin(user.getLogin())) {
            throw new UniqueValueException(ExceptionMessages.LOGIN_IS_ALREADY_EXIST.getMessage());
        }
        return userMapper.toDto(userRepository.save(user));
    }


    @Override
    @Transactional// CZY METODY CRUD Z JPA NIE SA DEFAULTOWO TRANSACTIONAL, TYLKO PRZY NADPISYWANIU NIE SA?
    public UserDto updateUser(UserDto userDto) {
        return userRepository.findById(userDto.getId()).map(user -> {
            user.setName(userDto.getName());
            user.setSurname(userDto.getSurname());
            user.setEmail(userDto.getEmail());
            user.setPhoneNumber(userDto.getPhoneNumber());
            return userMapper.toDto(user);
        }).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    ///////////
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException(
                String.format(USER_NOT_FOUND, login)
        ));
    }
    ////////////
}
