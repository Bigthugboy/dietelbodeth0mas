package semicolon.africa.testing.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import semicolon.africa.testing.data.model.Address;
import semicolon.africa.testing.data.model.Department;
import semicolon.africa.testing.data.model.Gender;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Gender gender;
    private String PhoneNumber;
    //private List<Address> address;
//    private String userName;
    private String DOB;

    private Department department;

}
