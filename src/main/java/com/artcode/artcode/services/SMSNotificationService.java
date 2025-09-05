package com.artcode.artcode.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("sms")
@Primary
public class SMSNotificationService implements NotificationService {

    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}
