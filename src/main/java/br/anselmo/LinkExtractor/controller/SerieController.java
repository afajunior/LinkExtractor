package br.anselmo.LinkExtractor.controller;

import br.anselmo.LinkExtractor.domain.StringResponse;
import br.anselmo.LinkExtractor.service.RabbitMQProducerService;
import br.anselmo.LinkExtractor.service.TVShowFinderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/serie")
public class SerieController {

    private final TVShowFinderService tvShowFinderService;
    private final RabbitMQProducerService rabbitMQSenderService;

    public SerieController(TVShowFinderService tvShowFinderService, RabbitMQProducerService rabbitMQSenderService) {
        this.tvShowFinderService = tvShowFinderService;
        this.rabbitMQSenderService = rabbitMQSenderService;
    }

    @GetMapping
    public StringResponse getUrl(String tvShowName) {
        rabbitMQSenderService.send("Hello World!");

        return tvShowFinderService.getUrl(tvShowName);
    }
}
