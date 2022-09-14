package africa.semicolon.tracker.data.repository;

import africa.semicolon.tracker.data.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    boolean existsByEmail(String email);

    Customer findByEmail(String email);


}
