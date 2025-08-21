package com.microservices.accounts.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id
    @Column(name = "user_id", columnDefinition = "BINARY(16)")
    private UUID userId;

    private String firstname;

    private String surname;

    private String insertions;

    public Account setFirstname(String firstname) {
        this.firstname = firstname;

        return this;
    }

    public Account setSurname(String surname) {
        this.surname = surname;

        return this;
    }

    public Account setInsertions(String insertions) {
        this.insertions = insertions;

        return this;
    }

    public String getFistname() {
        return this.firstname;
    }


    public String getSurname() {
        return this.surname;
    }

    public String getInsertions() {
        return this.insertions;
    }

    @Override
    public String toString() {
        return "User{"
                + "userId=" + userId
                + ", firstname='" + firstname + '\''
                + ", insertions='" + insertions + '\''
                + ", surname='" + surname + '\''
                + '}';
    }
}
