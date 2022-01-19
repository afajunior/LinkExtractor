package br.anselmo.LinkExtractor.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducerServiceImpl implements RabbitMQProducerService {
    private final AmqpTemplate rabbitTemplate;

    public RabbitMQProducerServiceImpl(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${linkExtractor.rabbitmq.exchange}")
    private String exchange;

    @Value("${linkExtractor.rabbitmq.routingkey}")
    private String routingkey;

    @Override
    public void send(String message) {
        rabbitTemplate.convertAndSend(exchange, routingkey, message);
    }
}
