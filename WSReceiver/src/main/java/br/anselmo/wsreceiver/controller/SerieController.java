package br.anselmo.wsreceiver.controller;

import br.anselmo.wsreceiver.domain.StringResponse;
import br.anselmo.wsreceiver.producer.ProducerMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/serie")
public class SerieController {

    private ProducerMessage producerMessage;

    public SerieController(ProducerMessage producerMessage) {
        this.producerMessage = producerMessage;
    }

    @GetMapping
    public StringResponse getUrl(String tvShowName) {
        producerMessage.send(tvShowName);
        return null;
    }
}
