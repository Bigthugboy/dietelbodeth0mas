package semicolon.africa.testing.services;

import semicolon.africa.testing.data.model.Student;
import semicolon.africa.testing.dto.request.RegisterCourseRequest;
import semicolon.africa.testing.dto.request.StudentLoginRequest;
import semicolon.africa.testing.dto.request.StudentRequest;
import semicolon.africa.testing.dto.response.RegisterCourseResponse;
import semicolon.africa.testing.dto.response.StudentLoginResponse;
import semicolon.africa.testing.dto.response.StudentResponse;

public interface StudentService {
    StudentResponse registerStudent(StudentRequest registerRequest);

    StudentLoginResponse loginStudent(StudentLoginRequest loginRequest);

    RegisterCourseResponse registerCourse(RegisterCourseRequest courseRequest);

    Student findByMail(StudentRequest studentRequest);

    StudentResponse updateStudent(StudentRequest studentRequest);

    StudentResponse deleteStudent(StudentRequest request);

}
