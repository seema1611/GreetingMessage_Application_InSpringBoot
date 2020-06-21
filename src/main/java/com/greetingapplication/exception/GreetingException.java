package com.greetingapplication.exception;

public class GreetingException extends RuntimeException {

    public ExceptionType type;

    public enum ExceptionType {
        USER_NOT_FOUND;
    }

    public GreetingException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}

