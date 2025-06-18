package com.example.JWT_Implementation_Demo.dto;


public class LoginRequestDTO {
    private String userEmail;
    private String password;

    public LoginRequestDTO() {
    }

    public LoginRequestDTO(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
