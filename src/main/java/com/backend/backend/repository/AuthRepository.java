package com.backend.backend.repository;

import com.backend.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    User findByEmail(String email);
    Boolean existsByEmail(String email);
    public User findByResetPasswordToken(String token);
    boolean existsByPhone(String phone);
    User getByResetPasswordToken(String token);
}
