package com.fooddude.cookbook.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String username){
        super("Error: User -> " + username + " not found.");
    }
}
