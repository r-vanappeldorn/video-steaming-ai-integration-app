package com.microservices.accounts.model;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class User {
    @Id
    @Column(name = "user_id", columnDefinition = "BINARY(16)")
    @GeneratedValue
    private UUID userId;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = false)
    private Account account;

    private String email;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password_hash")
    private String passwordHash;

    public User setEmail(String email) {
        this.email = email;

        return this;
    }

    public User setUserName(String userName) {
        this.userName = userName;

        return this;
    }

    public User setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;

        return this;
    }

    public UUID getUserId() {
        return this.userId;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public Account getAccount() {
        return this.account;
    }

    @Override
    public String toString() {
        return "User{"
                + "userId=" + userId
                + ", userName='" + userName + '\''
                + ", email='" + email + '\''
                + ", passwordHash='" + passwordHash + '\''
                + ", account='" + account.toString() + '\''
                + '}';
    }
}