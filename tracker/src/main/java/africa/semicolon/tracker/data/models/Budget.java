package africa.semicolon.tracker.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
@AllArgsConstructor

public class Budget {
    @Id
    private String id;
    private int amount;
    //@Enumerated.STRING
    private String categoryName;


}
