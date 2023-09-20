package com.example.example.model.constant;

import lombok.Getter;

@Getter
public enum ExceptionMessages {
    ACCOUNT_NOT_FOUND("Account is not found"),
    DEPARTMENT_NOT_FOUND("Department is nor found"),
    EMPLOYEE_NOT_FOUND("Employee is not found"),
    EMAIL_NOT_ALLOWED("Email address not allowed"),
    NAME_NOT_ALLOWED("Name not allowed"),
    BALANCE_NOT_ALLOWED("Amount not allowed"),
    AGE_NOT_ALLOWED("Age not allowed"),
    ROLE_NOT_ALLOWED("Role not allowed");

    private String message;

    ExceptionMessages(String message) {
        this.message = message;
    }
}
