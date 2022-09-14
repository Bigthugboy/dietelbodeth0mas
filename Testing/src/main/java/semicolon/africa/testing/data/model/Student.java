package semicolon.africa.testing.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
//    @Indexed(unique = true)
    private String email;
//    @Enumerated
    private Gender gender;
    private String password;
    private List<Address> address;
    private Boolean isSuspended;
    private Department department;
    private List<Courses> courses;
    private Grade grade;
//    private List<Cohort>cohorts;

    private LocalDateTime dateRegistered = LocalDateTime.now();
    private String DOB;


}
