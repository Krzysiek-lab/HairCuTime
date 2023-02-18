package com.example.haircuttime.EventHandler;


import com.example.haircuttime.model.entity.Absence;
import lombok.RequiredArgsConstructor;
import com.example.haircuttime.model.entity.Availability;
import com.example.haircuttime.model.entity.RoleEntity;
import com.example.haircuttime.model.entity.User;
import com.example.haircuttime.model.enums.Role;
import com.example.haircuttime.repository.AvailabilityRepository;
import com.example.haircuttime.repository.RoleEntityRepository;
import com.example.haircuttime.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;


import java.util.ArrayList;
import java.util.List;

@RepositoryEventHandler
@CommonsLog
@RequiredArgsConstructor
public class AbsenceRepositoryEventHandler {

    private final RoleEntityRepository roleRepository;
    private final UserRepository userRepository;
    private final AvailabilityRepository availabilityRepository;

    @HandleAfterCreate
    public void handleAbsenceBeforeCreate(Absence absence) {
        log.info("creating Absence entity");

        var availability = availabilityRepository.findAll().stream()
                .filter(e -> e.getStartTime().equals(
                        absence.getAbsenceStart())
                        && e.getEndTime().equals(absence.getAbsenceEnd())
                        && e.getBarber().equals(absence.getBarber())
                        && e.getWorkDay().equals(absence.getWorkDay()))
                .toList();

        availabilityRepository.delete(availability.get(0));
    }

    @HandleBeforeDelete
    public void handleAbsenceBeforeDelete(Absence absence) {
        log.info("deleting Absence entity");

        var availability = Availability.builder()
                .barber(absence.getBarber())
                .workDay(absence.getWorkDay())
                .endTime(absence.getAbsenceEnd())
                .startTime(absence.getAbsenceStart())
                .build();
        availabilityRepository.save(availability);
    }

    @HandleAfterCreate
    public void handleUserBeforeCreate(User user) {
        if (roleRepository.existsByName(Role.USER)) {
            user.setRoles(List.of(roleRepository.findByName(Role.USER)));
        } else {
            user.setRoles(List.of(RoleEntity.builder().name(Role.USER).build()));
        }
        log.info("assigning default role to new User entity");

        RoleEntity role = RoleEntity.builder()
                .name(Role.USER)
                .build();
        RoleEntity roleForUser = roleRepository.save(role);

        List<RoleEntity> roleList = user.getRoles();
        roleList.add(roleForUser);
        user.setRoles(roleList);
        userRepository.save(user);// czy trzeba??? bo to jest beforeCreate czy zmienic na beforeSave???
    }
}
