package com.fooddude.cookbook.exception;

public class InvalidRecipeIdException extends Exception {
    public InvalidRecipeIdException(Integer id){
        super("Error: Recipe Id -> " + id.toString() + " not found.");
    }
}
