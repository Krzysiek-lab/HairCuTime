package com.example.haircuttime.repository;

import com.example.haircuttime.model.entity.WorkDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkDefinitionRepository extends JpaRepository<WorkDefinition, Long>{
    WorkDefinition findByName(String name);
}
