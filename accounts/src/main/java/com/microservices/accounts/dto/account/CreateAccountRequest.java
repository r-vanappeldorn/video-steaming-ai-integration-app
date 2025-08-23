package com.microservices.accounts.dto.account;

import com.microservices.accounts.dto.common.JsonObject;

public class CreateAccountRequest extends JsonObject {
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String insertions;
    private String surname;

    public CreateAccountRequest(String username, String password, String email, String insertions, String surname) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.insertions = insertions;
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getInsertions() {
        return insertions;
    }

    public String getSurname() {
        return surname;
    }
}
