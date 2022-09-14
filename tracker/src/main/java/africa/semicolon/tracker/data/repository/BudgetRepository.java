package africa.semicolon.tracker.data.repository;

import africa.semicolon.tracker.data.models.Budget;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BudgetRepository extends MongoRepository<Budget, String> {
    Budget findByCategoryName(String categoryName);

    List<Budget> findAll();


}
