package com.artcode.artcode;

import com.artcode.artcode.services.EmailNotificationService;
import com.artcode.artcode.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NotificationManager {

    private NotificationService notificationService;

    public NotificationManager(@Qualifier("email") NotificationService notificationService ) {
        this.notificationService = notificationService;
    }

    public void sendNotification(String message) {
        notificationService.send(message);
    }
}
