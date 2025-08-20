package com.microservices.accounts.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class accountsController {

    @GetMapping("hello")
    public HashMap hello() {
        HashMap<String, String> response = new HashMap<>();

        response.put("name", "Rajeev");

        return response;
    }
}
