package com.example.JWT_Implementation_Demo.util;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class ValidDomainValidator implements ConstraintValidator<ValidDomain, String> {
    private String[] allowedDomains;

    @Override
    public void initialize(ValidDomain constraintAnnotation) {
        this.allowedDomains = constraintAnnotation.allowedDomains();
    }

    @Override
    public boolean isValid(String userEmail, ConstraintValidatorContext context) {
        System.out.println("Validating email: " + userEmail); // Debug

        if (userEmail == null || userEmail.trim().isEmpty()) {
            return false;
        }

        int atIndex = userEmail.indexOf("@");
        if (atIndex == -1 || atIndex == userEmail.length() - 1) {
            return false;
        }

        String domain = userEmail.substring(atIndex + 1).toLowerCase();
        return Arrays.asList(allowedDomains).contains(domain);
    }

}