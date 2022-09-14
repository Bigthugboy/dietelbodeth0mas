package semicolon.africa.testing.dto.request;

import lombok.*;
import semicolon.africa.testing.data.model.Courses;
import semicolon.africa.testing.data.model.Department;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterCourseRequest {
    private List<Courses> courses;
    private String email;
    private String password;
    private Department department;
}
