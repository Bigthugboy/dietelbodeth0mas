package semicolon.africa.testing.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import semicolon.africa.testing.dto.request.RegisterCourseRequest;
import semicolon.africa.testing.dto.request.StudentLoginRequest;
import semicolon.africa.testing.dto.request.StudentRequest;
import semicolon.africa.testing.dto.response.ApiResponse;
import semicolon.africa.testing.exception.DuplicateEmailException;
import semicolon.africa.testing.exception.StudentException;
import semicolon.africa.testing.services.StudentService;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class Controller {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody StudentRequest registerRequest) {
        try {
             studentService.registerStudent(registerRequest);
            ApiResponse response = ApiResponse.builder()
                    .isSuccessfully(true)
                    .data("successfully register! Welcome")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DuplicateEmailException ex) {
            ApiResponse response = ApiResponse.builder()
                    .isSuccessfully(false)
                    .data("email already exist")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody StudentLoginRequest request) {
        try {
             studentService.loginStudent(request);
            ApiResponse response =  ApiResponse.builder()
                    .isSuccessfully(true)
                    .data("logged in successfully, Welcome Back")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (IllegalStateException ex) {
            ApiResponse response =  ApiResponse.builder()
                    .isSuccessfully(false)
                    .data("login details not correct")
                    .build();

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/course")
    public ResponseEntity<?> RegisterCourse(@RequestBody RegisterCourseRequest CourseRequest) {
        try {
            studentService.registerCourse(CourseRequest);
            ApiResponse response =  ApiResponse.builder()
                    .isSuccessfully(true)
                    .data("course successfully registered")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DuplicateEmailException ex) {
            ApiResponse response =  ApiResponse.builder()
                    .isSuccessfully(false)
                    .data("please select course")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/findStudent")
    public ResponseEntity<?> findUserById(@RequestBody StudentRequest studentRequest){
        try {
            studentService.findByMail(studentRequest);
            ApiResponse apiResponse = ApiResponse.builder()
                    .isSuccessfully(true)
                    .data("student found")
                    .result(1)
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        } catch (StudentException e) {
            ApiResponse apiResponse = ApiResponse.builder()
                    .isSuccessfully(false)
                    .data("student not found")
                    .result(0)
                    .build();
            return new ResponseEntity<>(apiResponse, HttpStatus.valueOf(e.getMessage()));
        }
    }
}
