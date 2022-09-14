package africa.semicolon.tracker.data.models;

import lombok.Data;

@Data
public class Expenses {
    private Categories categories;
    private Budget budget;
}
