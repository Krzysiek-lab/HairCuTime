package com.example.haircuttime.repository;

import com.example.haircuttime.model.entity.Barber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberRepository extends JpaRepository<Barber,Long> {
}
