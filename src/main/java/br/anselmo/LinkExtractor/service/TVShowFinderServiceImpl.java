package br.anselmo.LinkExtractor.service;

import br.anselmo.LinkExtractor.domain.StringResponse;
import br.anselmo.LinkExtractor.exception.HostConnectionException;
import br.anselmo.LinkExtractor.exception.NotFoundException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TVShowFinderServiceImpl implements TVShowFinderService {

    @Value("${linkExtractor.webs.url}")
    private String website;

    public StringResponse getUrl(String serieName) {
        try {
            String xpath = String.format("//*[contains(@class, 'list-group-item')]/a[*/b=\"%s\"]", serieName);

            Element element = findElement(xpath);
            String tvShowUrl = element.attr("href");

            return new StringResponse(tvShowUrl);
        } catch (IOException e) {
            throw new HostConnectionException();
        }
    }

    public Element findElement(String xpath) throws IOException {
        String webUrl = getWebsiteUrl();
        Document doc = Jsoup.connect(webUrl).get();

        Elements elements = doc.selectXpath(xpath);
        if(elements.isEmpty())
            throw new NotFoundException();

        return elements.get(0);
    }

    public String getWebsiteUrl() {
        return website;
    }
}
