package com.example.JWT_Implementation_Demo.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class ValidDomainValidator implements ConstraintValidator<ValidDomain, String> {
    private String[] allowedDomains;

    @Override
    public void initialize(ValidDomain constraintAnnotation) {
        this.allowedDomains = constraintAnnotation.allowedDomains();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.isEmpty()) {
            return true;
        }
        String domain = email.substring(email.indexOf("@") + 1);
        return Arrays.asList(allowedDomains).contains(domain);
    }
}