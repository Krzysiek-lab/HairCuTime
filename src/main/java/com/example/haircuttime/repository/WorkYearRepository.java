package com.example.haircuttime.repository;

import com.example.haircuttime.model.entity.WorkYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkYearRepository extends JpaRepository<WorkYear, Long> {
    //Optional<WorkYear> findWorkYearByBarberIdAndYear(Long barberId, Long year);
}
