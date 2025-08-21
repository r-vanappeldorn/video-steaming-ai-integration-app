package com.microservices.accounts.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.accounts.model.User;

@RestController
class AccountsController {
    private List<User> users;

    @PostMapping("account/create")
    public User createAccount(@RequestBody User request) {
        System.out.println("Request: " + request);

        return new User();
    }

    @GetMapping("accounts")
    public List<User> hello() {
        return this.users;
    }
}
