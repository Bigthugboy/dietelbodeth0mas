package africa.semicolon.controller;

import africa.semicolon.data.model.Url;
import africa.semicolon.services.UrlServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shortener")
@Slf4j
public class UrlController {
    @Autowired
    private UrlServices urlServices;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOriginalUrl(@PathVariable String id) {
        log.info("here--->{}", "get original url");
        return ResponseEntity.ok(urlServices.getOriginalUrl(id));
    }

    @PostMapping("/url")
    public ResponseEntity<?> generateShortUrl(@RequestBody String url) {
        log.info("url-->{}", url);
        return ResponseEntity.ok(urlServices.generateShortUrl(url));
    }

}
