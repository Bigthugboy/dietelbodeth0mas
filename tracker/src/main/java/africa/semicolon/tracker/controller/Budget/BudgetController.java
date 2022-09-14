package africa.semicolon.tracker.controller.Budget;

import africa.semicolon.tracker.dto.request.BudgetRequest;
import africa.semicolon.tracker.dto.response.ApiResponse;
import africa.semicolon.tracker.exceptions.BudgetCategoryAlreadyExist;
import africa.semicolon.tracker.services.budget.BudgetServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class BudgetController {

    private BudgetServices budgetServices;

    public BudgetController(BudgetServices budgetServices) {
        this.budgetServices = budgetServices;
    }

    @PostMapping("/budget")
    public ResponseEntity<?> addToBudget(@RequestBody BudgetRequest request) {
        try {
            var serviceResponse = budgetServices.addToBudget(request);
            ApiResponse response = new ApiResponse(true, serviceResponse);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (BudgetCategoryAlreadyExist ex) {
            ApiResponse response = new ApiResponse(false, ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/budget/update")
    public ResponseEntity<?> update(@RequestBody BudgetRequest request) {
        try {
            var serviceResponse = budgetServices.update(request);
            ApiResponse response = new ApiResponse(true, serviceResponse);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse(false, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/budget/delete")
    public ResponseEntity<?> delete(@RequestBody BudgetRequest request) {
        try {
            var serviceResponse = budgetServices.deleteCategory(request);
            ApiResponse response = new ApiResponse(true, serviceResponse);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse(false, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/budget/deleteAll")
    public ResponseEntity<?> deleteAll(@RequestBody BudgetRequest request) {
        try {
            var serviceResponse = budgetServices.deleteAll(request);
            ApiResponse response = new ApiResponse(true, serviceResponse);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse(false, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/budget/expense")
    public ResponseEntity<?> calculate(@RequestBody BudgetRequest request) {
        try {
            var serviceResponse = budgetServices.expenses(request);
            ApiResponse response = new ApiResponse(true, serviceResponse);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponse response = new ApiResponse(false, e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


}

