package br.com.fiap.EcoSynergy.RabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {
    
    @RabbitListener(queues = "myQueue")
    public void receiveMessage(String message) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Received message: " + message);
    }
}