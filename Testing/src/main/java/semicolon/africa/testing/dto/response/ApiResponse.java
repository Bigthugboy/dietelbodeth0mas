package semicolon.africa.testing.dto.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ApiResponse {
    private boolean isSuccessfully;
    private Object data;
    private int result;
}
