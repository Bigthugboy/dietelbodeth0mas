package africa.semicolon.services;

import africa.semicolon.data.model.Url;
import africa.semicolon.data.repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static africa.semicolon.services.logic.GenerateShortUrl.getShortUrl;
import static africa.semicolon.services.logic.GenerateShortUrl.isUrlValid;

@Service
public class UrlServices {
    @Autowired
    private UrlRepository urlRepository;

    public String getOriginalUrl(String id) {
        return urlRepository.findUrlByShortUrl(id).getOriginalUrl();
    }

    public Url generateShortUrl(String url) {
        if (!isUrlValid(url)) {
            System.out.println("url is not valid");
            return null;
        }
        Url urlObject = new Url();
        urlObject.setOriginalUrl(url);
        urlObject.setShortUrl(getShortUrl(url));
        Url saved = urlRepository.save(urlObject);
        return generateShortUrl(saved.getShortUrl());
    }
}
