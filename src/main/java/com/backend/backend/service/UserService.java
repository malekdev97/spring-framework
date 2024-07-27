package com.backend.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.exception.DepartmentNotFoundException;
import com.backend.backend.model.User;
import com.backend.backend.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("User not found"));
        
        return user;
    
    }

    public User createUser(User user) {

        return userRepository.save(user);
    }
    
    public void deleteUser(Long id) {
        User newUser = userRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("User not found"));
    }
}
