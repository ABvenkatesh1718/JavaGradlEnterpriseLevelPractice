package com.venkatesh.enterpriselevelpractice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gmail", nullable = false, unique = true, length = 150)
    private String gmail;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "role", nullable = false, length = 50)
    private String role;

    public User() {}

    public User(String gmail, String password, String role, boolean isActive) {
        this.gmail = gmail;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
    }
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    // Update constructors if needed, or keep existing ones and ensure default is initialized
    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public String getGmail() {
        return gmail;
    }

    public void setEmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
