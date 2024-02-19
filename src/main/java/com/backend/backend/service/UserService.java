package com.backend.backend.service;


import javax.validation.Valid;

import com.backend.backend.entity.User;

public interface UserService {
    User getUser(Long id);
    User getUser(String username);
    User saveUser(User user);
    void login(@Valid User user);

}