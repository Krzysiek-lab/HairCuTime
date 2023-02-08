package com.example.haircuttime.repository;

import com.example.haircuttime.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByEmail(String email);

    Boolean existsByLogin(String login);

    @Query("select u from User u where u.login =:login")
    Optional<User> findByLogin(@Param("login") String login);
}
