package com.example.haircuttime.repository;

import com.example.haircuttime.model.entity.WorkDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkDefinitionRepository extends JpaRepository<WorkDefinition, Long>{
    Optional<WorkDefinition> findByName(String name);
}
