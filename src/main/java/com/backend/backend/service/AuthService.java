package com.backend.backend.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.backend.backend.entity.Role;
import com.backend.backend.entity.User;
import com.backend.backend.repository.AuthRepository;
import com.backend.backend.repository.RoleRepository;

import jakarta.validation.Valid;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User findUserByUsername(String username) {
        return authRepository.findByUsername(username).get();
    }

    public boolean existsByUsername(String username) {
        return authRepository.existsByUsername(username);
    }

    public User findByEmail(String email) {
        return authRepository.findByEmail(email);
    }

    public void updateResetPasswordToken(String token, String email) {
        User user = authRepository.findByEmail(email);
        if (user != null) {
            user.setResetPasswordToken(token);
            authRepository.save(user);
        }
        else {
            throw new RuntimeException("Could not find any customer with the email " + email);
        }
    }

    public User findByResetPasswordToken(String token) {
        return authRepository.findByResetPasswordToken(token);
    }

    public void updatePassword( User user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
    }

    public void save(@Valid User user) throws MethodArgumentNotValidException {

        if(authRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        
        if(authRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        if(authRepository.existsByPhone(user.getPhone())) {
            throw new RuntimeException("Phone already exists");
        }

        if(user.getPassword().length() < 8 || user.getPassword().length() > 20) {
            throw new RuntimeException("Password must be between 8 and 20 characters");

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());
        newUser.setPhone(user.getPhone());
        newUser.setResetPasswordToken(user.getResetPasswordToken());
        newUser.setPassword(user.getPassword());
        
        Role role = roleRepository.findByName("USER").get();
        user.setRole(Collections.singletonList(role));

        authRepository.save(user);
    }

    public User getByResetPasswordToken(String token) {
        return authRepository.findByResetPasswordToken(token);
    }

    public User findByUsername(String username) {
        return authRepository.findByUsername(username).get();
    }
    
}
