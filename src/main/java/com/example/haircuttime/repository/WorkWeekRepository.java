package com.example.haircuttime.repository;

import com.example.haircuttime.model.schedule.WorkWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkWeekRepository extends JpaRepository<WorkWeek, Long> {

}
