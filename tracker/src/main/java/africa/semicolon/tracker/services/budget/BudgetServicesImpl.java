package africa.semicolon.tracker.services.budget;

import africa.semicolon.tracker.data.models.Budget;
import africa.semicolon.tracker.data.repository.BudgetRepository;
import africa.semicolon.tracker.dto.request.BudgetRequest;
import africa.semicolon.tracker.dto.response.BudgetResponse;
import africa.semicolon.tracker.exceptions.BudgetCategoryAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetServicesImpl implements BudgetServices {
    @Autowired
    private BudgetRepository budgetRepository;


    @Override
    public BudgetResponse addToBudget(BudgetRequest request) throws BudgetCategoryAlreadyExist {
        if (categoryNameExists(request.getCategoryName())) {
            throw new BudgetCategoryAlreadyExist("category already exist");
        }
        Budget budget = new Budget();

        budget.setCategoryName(request.getCategoryName());
        budget.setAmount(request.getAmount());
        budgetRepository.save(budget);
        BudgetResponse response = new BudgetResponse();
        response.setMessage("Category successfully created");
        return response;


    }

    private boolean categoryNameExists(String categoryName) {
        Budget budget = budgetRepository.findByCategoryName(categoryName);
        return budget != null;
    }

    @Override
    public int expenses(BudgetRequest request) {
        // Budget expenses = (Budget) budgetRepository.findAll();
        int total = 0;
        List<Budget> budgetList = budgetRepository.findAll();
        for (int i = 0; i < budgetRepository.findAll().size(); i++) {
            total += budgetList.get(i).getAmount();
        }
        return total;
    }

    @Override
    public BudgetResponse update(BudgetRequest request) {
        // List<Budget> budgetList = budgetRepository.findAll();
        Budget budget = budgetRepository.findByCategoryName(request.getCategoryName());
        //budgetList.equals(request.getCategoryName());

        budget.setCategoryName(request.getCategoryName());
        budget.setAmount(request.getAmount());
        budgetRepository.save(budget);
        BudgetResponse response = new BudgetResponse();
        response.setMessage("Category successfully updated");
        return response;


    }

    @Override
    public BudgetResponse deleteCategory(BudgetRequest request) {
        //List<Budget>budgetList = budgetRepository.findAll();
        Budget budget = budgetRepository.findByCategoryName(request.getCategoryName());
        budgetRepository.delete(budget);
        BudgetResponse response = new BudgetResponse();
        response.setMessage("Category successfully deleted");
        return response;

    }

    @Override
    public BudgetResponse deleteAll(BudgetRequest request) {
        budgetRepository.deleteAll();
        BudgetResponse response = new BudgetResponse();
        response.setMessage(" ALL Category successfully deleted");
        return response;

    }

}
