package com.fooddude.cookbook.exception;

public class IncorrectPasswordException extends Exception {
    public IncorrectPasswordException(){
        super("Error: Incorrect Password was Entered");
    }
}
