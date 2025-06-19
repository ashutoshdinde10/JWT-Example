package com.example.JWT_Implementation_Demo.dto;


import com.example.JWT_Implementation_Demo.util.ValidDomain;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequestDTO {
    @ValidDomain(allowedDomains = {"coditas.com", "coditas.org"}, message = "Email Not Valid")
    private String userEmail;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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
