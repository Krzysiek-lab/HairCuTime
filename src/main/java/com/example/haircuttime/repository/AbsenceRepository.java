package com.example.haircuttime.repository;


import com.example.haircuttime.model.entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {
    List<Absence> findAbsencesByWorkDay_Id(Long workDayId);
}
