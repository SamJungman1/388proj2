package com.example.Backend.UserControllers;

public class IncorrectPasswordException extends Exception {
    public IncorrectPasswordException(String errorMessage)
    {
        super(errorMessage);
    }
    public IncorrectPasswordException()
    {
        super();
    }
}
