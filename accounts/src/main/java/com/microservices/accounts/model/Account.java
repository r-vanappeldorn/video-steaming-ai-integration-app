package com.microservices.accounts.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Account {
    @Id
    @Column(name = "user_id", columnDefinition = "BINARY(16)")
    private UUID userId;

    private String firstname;

    private String surname;

    private String insertions;

    @OneToOne
    @MapsId  
    @JoinColumn(name = "user_id")
    private User user;

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

    public User getUser() {
        return this.user;
    }

    @Override
    public String toString() {
        return "Account{"
                + "userId=" + userId
                + ", firstname='" + firstname + '\''
                + ", insertions='" + insertions + '\''
                + ", surname='" + surname + '\''
                + '}';
    }
}
