package semicolon.africa.testing.data.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
public class Cohort {
    @Id
    private String id;
    private Department department;

    public Cohort(Department department) {
        this.department = department;
    }
}
