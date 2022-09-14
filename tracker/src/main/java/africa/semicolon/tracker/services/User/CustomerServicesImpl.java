package africa.semicolon.tracker.services.User;

import africa.semicolon.tracker.data.models.Customer;
import africa.semicolon.tracker.data.repository.CustomerRepository;
import africa.semicolon.tracker.dto.request.LoginRequest;
import africa.semicolon.tracker.dto.request.RegisterUserRequest;
import africa.semicolon.tracker.dto.response.LoginUserResponse;
import africa.semicolon.tracker.dto.response.RegisterUserResponse;
import africa.semicolon.tracker.exceptions.DuplicateEmailException;
import africa.semicolon.tracker.exceptions.InvalidDetailsException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class CustomerServicesImpl implements CustomerServices {

    private CustomerRepository customerRepository;


    public CustomerServicesImpl(@Autowired CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) throws DuplicateEmailException {
        if (customerRepository.existsByEmail(request.getEmail()))
            throw new DuplicateEmailException(request.getEmail() + " already exists");
        Customer customer = new Customer();
        customer.setEmail(request.getEmail());
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setPassword(request.getPassword());
        Customer savedCustomer = customerRepository.save(customer);
        RegisterUserResponse response = new RegisterUserResponse();
        response.setEmail(savedCustomer.getEmail());
        response.setDateCreated(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyy, hh:mm, a").format(savedCustomer.getDateRegistered()));
        return response;
    }


    @Override
    public LoginUserResponse loginUser(LoginRequest request) throws InvalidDetailsException {
        Customer customer = customerRepository.findByEmail(request.getEmail());

        LoginUserResponse response = new LoginUserResponse();
        if (customer.getPassword().equals(request.getPassword())) {
            response.setMessage("Logged in successfully");
            return response;
        }
        throw new InvalidDetailsException("Invalid login details");
    }


}
