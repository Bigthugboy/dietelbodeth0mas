package semicolon.africa.testing.data.model;

import lombok.*;

@Builder

public class Courses {
    private Subject subject;


    public Courses(Subject subject) {
        this.subject = subject;

    }

}
