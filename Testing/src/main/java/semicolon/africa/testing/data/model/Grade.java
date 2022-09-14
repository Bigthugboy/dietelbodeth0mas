package semicolon.africa.testing.data.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class Grade {
    private List<Courses> courses;
    private Subject subject;
    private int grade;

    public Grade(List<Courses> courses, int grade, Subject subject) {
        this.courses = courses;
        this.grade = grade;
        this.subject = subject;
    }

}
