package com.artcode.artcode;

import com.artcode.artcode.services.EmailNotificationService;
import com.artcode.artcode.services.NotificationService;
import com.artcode.artcode.services.SMSNotificationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ArtcodeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ArtcodeApplication.class, args);

		NotificationManager manager = context.getBean(NotificationManager.class);
		manager.sendNotification("Hello Spring");
	}

}
