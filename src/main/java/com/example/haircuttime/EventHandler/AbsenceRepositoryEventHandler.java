package com.example.haircuttime.EventHandler;


import com.example.haircuttime.model.entity.Absence;
import com.example.haircuttime.model.entity.User;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler
@CommonsLog
public class AbsenceRepositoryEventHandler {

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
        log.info("assigning default role to new User entity");
    }
}
