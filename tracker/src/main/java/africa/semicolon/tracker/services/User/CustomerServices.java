package africa.semicolon.tracker.services.User;


import africa.semicolon.tracker.dto.request.LoginRequest;

import africa.semicolon.tracker.dto.response.LoginUserResponse;
import africa.semicolon.tracker.dto.response.RegisterUserResponse;
import africa.semicolon.tracker.dto.request.RegisterUserRequest;
import africa.semicolon.tracker.exceptions.DuplicateEmailException;
import africa.semicolon.tracker.exceptions.InvalidDetailsException;

public interface CustomerServices {
    RegisterUserResponse registerUser(RegisterUserRequest request) throws DuplicateEmailException;

    LoginUserResponse loginUser(LoginRequest request) throws InvalidDetailsException;


}
