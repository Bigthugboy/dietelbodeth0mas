package africa.semicolon.data.repositories;

import africa.semicolon.data.model.Url;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UrlRepository extends MongoRepository<Url, String> {
    Url findUrlByShortUrl(String shorturl);

}
