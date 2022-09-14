package semicolon.africa.testing.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.africa.testing.data.model.*;
import semicolon.africa.testing.dto.request.RegisterCourseRequest;
import semicolon.africa.testing.dto.request.StudentLoginRequest;
import semicolon.africa.testing.dto.request.StudentRequest;
import semicolon.africa.testing.dto.response.RegisterCourseResponse;
import semicolon.africa.testing.dto.response.StudentLoginResponse;
import semicolon.africa.testing.dto.response.StudentResponse;
import semicolon.africa.testing.exception.DuplicateEmailException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServicesTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void studentCanRegister() throws DuplicateEmailException {
        try {
            Address address = new Address();
            address.setCity("lagos");
            address.setCountry("nigeria");
            address.setPostcode(100001);
            List<Address> addresses = new ArrayList<>();
            addresses.add(address);
            StudentRequest registerRequest = StudentRequest.builder()
                    //.address(addresses)
                    .firstName("damilola")
                    .lastName("ayodeji")
                    .password("dammy")
                    .PhoneNumber("08012345678")
                    .email("damilola@gmail.com")
                    .gender(Gender.MALE)

                    .DOB("01-02-1990")
                    .build();
            StudentResponse registerResponse = studentService.registerStudent(registerRequest);
            assertEquals("damilola@gmail.com", registerResponse.getEmail());
        } catch (DuplicateEmailException e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void StudentCanLogin() {
        StudentLoginRequest loginRequest = StudentLoginRequest.builder()
                .email("damilola@gmail.com")
                .password("dammy")
                .build();
        StudentLoginResponse loginResponse = studentService.loginStudent(loginRequest);
        assertEquals("logged in successfully", loginResponse.getMessage());
    }

    @Test
    public void studentCanRegisterAndSelectDepartmentAndSubject() {
        Address address = new Address();
        address.setCity("ogun");
        address.setCountry("nigeria");
        address.setPostcode(100001);
        List<Address> addresses = new ArrayList<>();

        StudentRequest registerRequest = StudentRequest.builder()
              //  .address(addresses)
                .firstName("oloko")
                .lastName("funmilayo")
                .password("damilola")
                .PhoneNumber("08012345678")
                .email("queen@gmail.com")
                .gender(Gender.FEMALE)

                .department(Department.SCIENCE_CLASS)
                .DOB("01-02-1995")
                .build();
        StudentResponse registerResponse = studentService.registerStudent(registerRequest);
        assertEquals("queen@gmail.com", registerResponse.getEmail());
    }

    @Test
    public void TestThatStudentCanSelectSubject() throws DuplicateEmailException {
        try {
            List<Courses> coursesList = new ArrayList<>();
            coursesList.add(new Courses(Subject.MATHEMATICS));
            coursesList.add(new Courses(Subject.ENGLISH));
            coursesList.add(new Courses(Subject.BIOLOGY));
            coursesList.add(new Courses(Subject.CHEMISTRY));
            coursesList.add(new Courses(Subject.FURTHER_MATHEMATICS));
            coursesList.add(new Courses(Subject.PHYSIC));
            coursesList.add(new Courses(Subject.TECHNICAL_DRAWING));
            coursesList.add(new Courses(Subject.CIVIC));
            coursesList.add(new Courses(Subject.ECONOMICS));
            RegisterCourseRequest courseRequest = RegisterCourseRequest.builder()
                    .email("damilola@gmail.com")
                    .password("dammy")
                    .department(Department.SCIENCE_CLASS)
                    .courses(coursesList)
                    .build();
            RegisterCourseResponse courseResponse = studentService.registerCourse(courseRequest);
            assertEquals("damilola@gmail.com", courseResponse.getEmail());
        } catch (DuplicateEmailException e) {
            System.out.println(e.getMessage());
        }
    }
}