package semicolon.africa.testing.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCourseResponse {
    private String message;
    private String email;
    private LocalDateTime dateRegistered;
}
