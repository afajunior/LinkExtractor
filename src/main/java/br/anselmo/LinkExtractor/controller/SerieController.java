package br.anselmo.LinkExtractor.controller;

import br.anselmo.LinkExtractor.domain.StringResponse;
import br.anselmo.LinkExtractor.service.TVShowFinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/serie")
public class SerieController {

    /*
        TODO: Melhor forma de tratar aspas no xpath
     */

    @GetMapping
    public StringResponse getUrl(String tvShowName) throws Exception {
        TVShowFinder finder = new TVShowFinder();
        return finder.getUrl(tvShowName);
    }
}
