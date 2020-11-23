package com.example.Backend.UserControllers;

public class UnauthorizedAttemptException extends Exception {
    public UnauthorizedAttemptException(String errorMessage)
    {
        super(errorMessage);
    }
    public UnauthorizedAttemptException()
    {
        super();
    }
}
