package br.anselmo.wsreceiver.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerMessage {
    private final AmqpTemplate rabbitTemplate;

    public ProducerMessage(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${linkExtractor.rabbitmq.exchange}")
    private String exchange;

    @Value("${linkExtractor.rabbitmq.routingkey}")
    private String routingkey;

    public void send(String tvShowName) {
        rabbitTemplate.convertAndSend(exchange, routingkey, tvShowName);
    }
}
