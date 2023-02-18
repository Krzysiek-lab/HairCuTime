package com.example.haircuttime.EventHandler;


import com.example.haircuttime.model.entity.Absence;
import com.example.haircuttime.model.entity.RoleEntity;
import com.example.haircuttime.model.entity.User;
import com.example.haircuttime.model.enums.Role;
import com.example.haircuttime.repository.RoleEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.util.List;

@RepositoryEventHandler
@CommonsLog
@RequiredArgsConstructor
public class AbsenceRepositoryEventHandler {

    private final RoleEntityRepository roleRepository;

    @HandleBeforeCreate
    public void handleAbsenceBeforeCreate(Absence absence) {
        log.info("creating Absence entity");
    }

    @HandleBeforeDelete
    public void handleAbsenceBeforeDelete(Absence absence) {
        log.info("deleting Absence entity");
    }

    @HandleBeforeCreate
    public void handleUserBeforeCreate(User user) {
        if (roleRepository.existsByName(Role.USER)) {
            user.setRoles(List.of(roleRepository.findByName(Role.USER)));
        } else {
            user.setRoles(List.of(RoleEntity.builder().name(Role.USER).build()));
        }
        log.info("assigning default role to new User entity");
    }
}
