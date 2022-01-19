package br.anselmo.linkprocessor.consumer;

import br.anselmo.linkprocessor.domain.StringResponse;
import br.anselmo.linkprocessor.producer.ProducerMessage;
import br.anselmo.linkprocessor.service.TVShowFinderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class ConsumerMessage {

    private TVShowFinderService tvShowFinderService;
    private ProducerMessage producerMessage;

    public ConsumerMessage(TVShowFinderService tvShowFinderService, ProducerMessage producerMessage) {
        this.tvShowFinderService = tvShowFinderService;
        this.producerMessage = producerMessage;
    }

    @RabbitListener(queues = "linkExtractor.queue")
    public void consumer(String serieName) {
        StringResponse response = tvShowFinderService.getUrl(serieName);
        producerMessage.send(response);
    }
}
