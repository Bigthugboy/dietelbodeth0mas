package semicolon.africa.testing.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import semicolon.africa.testing.data.model.Student;
import semicolon.africa.testing.data.repository.StudentRepository;
import semicolon.africa.testing.dto.request.RegisterCourseRequest;
import semicolon.africa.testing.dto.request.StudentLoginRequest;
import semicolon.africa.testing.dto.request.StudentRequest;
import semicolon.africa.testing.dto.response.RegisterCourseResponse;
import semicolon.africa.testing.dto.response.StudentLoginResponse;
import semicolon.africa.testing.dto.response.StudentResponse;
import semicolon.africa.testing.exception.DuplicateEmailException;
import semicolon.africa.testing.exception.InvalidDetailsException;
import semicolon.africa.testing.exception.StudentNotFoundException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class StudentServicesImpl implements StudentService {
    private StudentRepository studentRepository;


    @Override
    public StudentResponse registerStudent(StudentRequest registerRequest) throws DuplicateEmailException {

        Student sstudent = studentRepository.findByEmail(registerRequest.getEmail());
        if (sstudent != null) {
            throw new DuplicateEmailException(registerRequest.getEmail() + "email already exist");
        }
        Student student = new Student();
        ModelMapper modelMapper;
        modelMapper = new ModelMapper();
       student = modelMapper.map(registerRequest, Student.class);
        Student savedStudent = studentRepository.save(student);
        StudentResponse response = new StudentResponse();
        response.setEmail(savedStudent.getEmail());
        response.setDateCreated(LocalDateTime.parse(DateTimeFormatter.ofPattern("EEEE,dd/MM/yyy, hh:mm, a").format(savedStudent.getDateRegistered())));

        return response;
    }

    @Override
    public StudentLoginResponse loginStudent(StudentLoginRequest loginRequest) {
        Student student = studentRepository.findByEmail(loginRequest.getEmail());
        StudentLoginResponse response = new StudentLoginResponse();
        if (student.getPassword().equals(loginRequest.getPassword())) {
            response.setMessage("logged in successfully");
            return response;
        }
        throw new InvalidDetailsException("Invalid login details");
    }

    @Override
    public RegisterCourseResponse registerCourse(RegisterCourseRequest courseRequest) {
        Student student = studentRepository.findByEmail(courseRequest.getEmail());
        if(student.getEmail() == null){
            throw new StudentNotFoundException(courseRequest.getEmail() + "email does not exist");
        }
            student.setCourses(courseRequest.getCourses());
        Student savedStudent = studentRepository.save(student);
        RegisterCourseResponse courseResponse = new RegisterCourseResponse();
        courseResponse.setEmail(savedStudent.getEmail());
        courseResponse.setMessage(savedStudent.getEmail());
        courseResponse.setDateRegistered(savedStudent.getDateRegistered());

        return courseResponse;
    }

    @Override
    public Student findByMail(StudentRequest studentRequest) {
        Student student = studentRepository.findByEmail(studentRequest.getEmail());
        if (student.getEmail().equals(studentRequest.getEmail())) {
            return student;
        } throw new StudentNotFoundException("student not found");
    }

    @Override
    public StudentResponse updateStudent(StudentRequest studentRequest) {
        Student student = studentRepository.findByEmail(studentRequest.getEmail());
        if (student.getEmail().equals(studentRequest.getEmail())) {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(student, studentRequest);
            studentRepository.save(student);
            StudentResponse response = new StudentResponse();
            response.setEmail(studentRequest.getEmail());
            response.setMessage("updated successfully");
            return response;
        }
        return null;
    }

    @Override
    public StudentResponse deleteStudent(StudentRequest request) {
        Student student = studentRepository.findByEmail(request.getEmail());
        studentRepository.delete(student);
        StudentResponse response = new StudentResponse();
        response.setMessage("delete successfully");
        return response;
    }
}
