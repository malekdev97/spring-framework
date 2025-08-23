package com.backend.backend.services;

import com.backend.backend.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void handleMessage(String message) {
        System.out.println("\nReceived message from RabbitMQ: " + message);
    }
}
