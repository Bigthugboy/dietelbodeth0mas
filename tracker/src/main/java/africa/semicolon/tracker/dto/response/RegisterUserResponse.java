package africa.semicolon.tracker.dto.response;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserResponse {
    private String email;
    private String dateCreated;
    private String message;

}
