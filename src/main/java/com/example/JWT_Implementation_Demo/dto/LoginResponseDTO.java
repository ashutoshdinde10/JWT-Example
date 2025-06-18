package com.example.JWT_Implementation_Demo.dto;

import java.util.List;

public class LoginResponseDTO {
    private String token;
    private String message;
    private String email;
    private String role;
    private List<String> operations;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String token, String message, String email, String role, List<String> operations) {
        this.token = token;
        this.message = message;
        this.email = email;
        this.role = role;
        this.operations = operations;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getOperations() {
        return operations;
    }

    public void setOperations(List<String> operations) {
        this.operations = operations;
    }
}
