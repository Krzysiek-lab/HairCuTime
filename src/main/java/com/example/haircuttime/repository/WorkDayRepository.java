package com.example.haircuttime.repository;

import com.example.haircuttime.model.schedule.WorkDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkDayRepository extends JpaRepository<WorkDay, Long> {

}
