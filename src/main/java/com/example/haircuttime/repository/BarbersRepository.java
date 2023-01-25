package com.example.haircuttime.repository;

import com.example.haircuttime.model.Barbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarbersRepository extends JpaRepository<Barbers,Long> {
}