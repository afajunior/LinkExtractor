package br.anselmo.LinkExtractor.service;

import br.anselmo.LinkExtractor.domain.StringResponse;
import br.anselmo.LinkExtractor.exception.HostConnectionException;
import br.anselmo.LinkExtractor.exception.NotFoundException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TVShowFinder {

    private final String WEBSITE = "https://www.watchseries1.video/all-series";

    public StringResponse getUrl(String serieName) throws Exception {
        try {
            String xpath = "//*[contains(@class, 'list-group-item')]/a[*/b=\"" + serieName + "\"]";

            Element element = findElement(xpath);

            String tvShowUrl = element.attr("href");
            return new StringResponse(tvShowUrl);
        } catch (IOException e) {
            throw new HostConnectionException();
        }
    }

    public Element findElement(String xpath) throws Exception {
        String webUrl = getWebsiteUrl();
        Document doc = Jsoup.connect(webUrl).get();

        Elements elements = doc.selectXpath(xpath);
        if(elements.isEmpty())
            throw new NotFoundException();

        return elements.get(0);
    }

    public String getWebsiteUrl() {
        return WEBSITE;
    }
}