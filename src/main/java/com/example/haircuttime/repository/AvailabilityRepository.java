package com.example.haircuttime.repository;

import com.example.haircuttime.model.entity.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    List<Availability> findAvailabilitiesByBarberId(Long barberId);
    List<Availability> findAvailabilitiesByWorkDay_Id(Long workDayId);
}
