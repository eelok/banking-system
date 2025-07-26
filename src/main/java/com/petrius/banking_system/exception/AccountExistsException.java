package com.petrius.banking_system.exception;

public class AccountExistsException extends RuntimeException {

    public AccountExistsException(String message) {
        super(message);
    }
}
