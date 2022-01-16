package br.anselmo.LinkExtractor.controller;

import br.anselmo.LinkExtractor.domain.StringResponse;
import br.anselmo.LinkExtractor.service.TVShowFinderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/serie")
public class SerieController {

    private final TVShowFinderService tvShowFinderService;

    public SerieController(TVShowFinderService tvShowFinderService) {
        this.tvShowFinderService = tvShowFinderService;
    }

    @GetMapping
    public StringResponse getUrl(String tvShowName) {
        return tvShowFinderService.getUrl(tvShowName);
    }
}
