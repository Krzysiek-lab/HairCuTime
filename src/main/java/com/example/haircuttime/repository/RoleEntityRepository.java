package com.example.haircuttime.repository;

import com.example.haircuttime.model.entity.RoleEntity;
import com.example.haircuttime.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {

    Boolean existsByName(Role name);

    RoleEntity findByName(Role name);
}
