package com.example.JWT_Implementation_Demo.dto;

public class SignupRequest {
    private String username;
    private String userEmail;
    private String password;
    private String roleName;

    public SignupRequest() {
    }

    public SignupRequest(String username, String userEmail, String password, String roleName) {
        this.username = username;
        this.userEmail = userEmail;
        this.password = password;
        this.roleName = roleName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
