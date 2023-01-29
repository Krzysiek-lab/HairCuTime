package com.example.haircuttime.repository;

import com.example.haircuttime.model.entity.WorkWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkWeekRepository extends JpaRepository<WorkWeek, Long> {

    Optional<WorkWeek> findWorkWeekByWeekNumber(Long weekNumber);
}
