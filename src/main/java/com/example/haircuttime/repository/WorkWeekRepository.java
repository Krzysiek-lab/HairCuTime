package com.example.haircuttime.repository;

import com.example.haircuttime.model.entity.WorkDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkWeekRepository extends JpaRepository<WorkDay, Long> {
}
