package br.anselmo.LinkExtractor.service;

import br.anselmo.LinkExtractor.domain.StringResponse;

public interface TVShowFinderService {
    StringResponse getUrl(String serieName);
}
