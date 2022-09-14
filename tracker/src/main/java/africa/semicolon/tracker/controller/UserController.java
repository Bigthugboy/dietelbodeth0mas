package africa.semicolon.tracker.controller;

import africa.semicolon.tracker.dto.request.LoginRequest;
import africa.semicolon.tracker.dto.request.RegisterUserRequest;
import africa.semicolon.tracker.dto.response.ApiResponse;
import africa.semicolon.tracker.exceptions.DuplicateEmailException;
import africa.semicolon.tracker.exceptions.InvalidDetailsException;
import africa.semicolon.tracker.services.User.CustomerServices;
import africa.semicolon.tracker.services.budget.BudgetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private CustomerServices userServices;

    @Autowired
    public UserController(CustomerServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/customer")
    public ResponseEntity<?> addUser(@RequestBody RegisterUserRequest request) {
        try {
            var serviceResponse = userServices.registerUser(request);
            ApiResponse response = new ApiResponse(true, serviceResponse);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DuplicateEmailException ex) {
            ApiResponse response = new ApiResponse(false, ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/customer/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            return new ResponseEntity<>(userServices.loginUser(loginRequest), HttpStatus.OK);
        } catch (IllegalArgumentException | InvalidDetailsException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
  




