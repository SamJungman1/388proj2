package com.example.Backend.UserControllers;

public class EmailAlreadyExistsException extends Exception{
    public EmailAlreadyExistsException(String errorMessage)
    {
        super(errorMessage);
    }
    public EmailAlreadyExistsException()
    {
        super();
    }
}
