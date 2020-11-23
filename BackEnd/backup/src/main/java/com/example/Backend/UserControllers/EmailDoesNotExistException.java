package com.example.Backend.UserControllers;

public class EmailDoesNotExistException extends Exception {
    public EmailDoesNotExistException(String errorMessage)
    {
        super(errorMessage);
    }
    public EmailDoesNotExistException()
    {
        super();
    }
}
