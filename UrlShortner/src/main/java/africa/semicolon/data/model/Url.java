package africa.semicolon.data.model;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Url {
    @Id
    private String id;
    private String shortUrl;
    private String originalUrl;
}
