package com.backend.backend.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.backend.backend.repository.UserRepository;

public class UserService {

    private UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return null;
    }
    
}
