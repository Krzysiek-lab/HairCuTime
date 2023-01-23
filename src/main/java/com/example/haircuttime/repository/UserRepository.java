package com.example.haircuttime.repository;

import com.example.haircuttime.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
