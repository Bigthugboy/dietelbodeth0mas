package africa.semicolon.tracker.services.budget;

import africa.semicolon.tracker.dto.request.BudgetRequest;
import africa.semicolon.tracker.dto.response.BudgetResponse;
import africa.semicolon.tracker.exceptions.BudgetCategoryAlreadyExist;

public interface BudgetServices {
    BudgetResponse addToBudget(BudgetRequest budgetRequest) throws BudgetCategoryAlreadyExist;

    int expenses(BudgetRequest request);

    BudgetResponse update(BudgetRequest request);

    BudgetResponse deleteCategory(BudgetRequest request);

    BudgetResponse deleteAll(BudgetRequest request);

}
