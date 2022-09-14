package semicolon.africa.testing.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentLoginRequest {
    private String email;
    private String password;
}
