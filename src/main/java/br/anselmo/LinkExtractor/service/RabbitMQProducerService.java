package br.anselmo.LinkExtractor.service;

public interface RabbitMQProducerService {
    void send(String message);
}
