package semicolon.africa.testing.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import semicolon.africa.testing.data.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    Student findByEmail(String email);

}
