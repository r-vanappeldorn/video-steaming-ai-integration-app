package com.microservices.accounts.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.accounts.dto.account.CreateAccountRequest;
import com.microservices.accounts.dto.common.ApiResponse;
import com.microservices.accounts.dto.common.ErrorDetail;
import com.microservices.accounts.model.Account;
import com.microservices.accounts.model.User;

@RestController
class AccountsController {
    private static final String PASSWORD_REGEX = "^(?=.*[^a-zA-Z0-9]).{12,}$";
    private final List<User> users = new CopyOnWriteArrayList<>();

    private boolean isPasswordValid(String password) {
        boolean isValid = Pattern.compile(PASSWORD_REGEX).matcher(password).find();

        return isValid;
    }

    @PostMapping("accounts/create")
    public ResponseEntity<ApiResponse> createAccount(@RequestBody CreateAccountRequest request) {
        if (!this.isPasswordValid(request.getPassword())) {
            ApiResponse<Void> errorResponse = ApiResponse.badRequest(
                    new ErrorDetail("VALIDATION_ERROR", "Password must be 12 characters long and contain special characters")
            );

            return ResponseEntity.badRequest().body(errorResponse);
        }

        Account account = new Account()
                .setFirstname(request.getFirstname())
                .setInsertions(request.getInsertions())
                .setSurname(request.getSurname());

        User user = new User()
                .setEmail(request.getEmail())
                .setUsername(request.getUsername())
                .setAccount(account);

        System.out.println(user);

        this.users.add(user);
        ApiResponse<User> response = ApiResponse.ok(user);
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("accounts")
    public List<User> hello() {
        return this.users;
    }
}
