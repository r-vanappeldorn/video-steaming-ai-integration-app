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

    @Column(name = "username")
    private String username;

    @Column(name = "password_hash")
    private String passwordHash;

    public User setEmail(String email) {
        this.email = email;

        return this;
    }

    public User setUserName(String userName) {
        this.username = userName;

        return this;
    }

    public User setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;

        return this;
    }
    
    public User setAccount(Account account) {
        this.account = account;

        return this;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "User{"
                + "userId=" + userId
                + ", userName='" + username + '\''
                + ", email='" + email + '\''
                + ", passwordHash='" + passwordHash + '\''
                + ", account='" + account.toString() + '\''
                + '}';
    }
}