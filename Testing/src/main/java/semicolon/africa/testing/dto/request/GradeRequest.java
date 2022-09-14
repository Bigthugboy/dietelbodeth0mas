package semicolon.africa.testing.dto.request;

import lombok.*;
import semicolon.africa.testing.data.model.Courses;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GradeRequest {
    private List<Courses> courses;
    private int grade;

}
