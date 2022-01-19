package br.anselmo.LinkExtractor.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumerService {
    @RabbitListener(queues = "linkExtractor.queue")
    public void consumer(String message) {
        System.out.println(message);
    }
}
