package com.artcode.artcode.services;

import org.springframework.stereotype.Service;

@Service
public interface NotificationService {

    public void send(String message);
}
