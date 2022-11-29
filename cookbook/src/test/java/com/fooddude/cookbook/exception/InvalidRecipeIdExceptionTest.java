package com.fooddude.cookbook.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvalidRecipeIdExceptionTest {
    private final String expected = "Error: Recipe Id -> 1 not found.";
    private final InvalidRecipeIdException invalidRecipeIdException = new InvalidRecipeIdException(1);

    @Test
    public void invalidRecipeIdException(){
        String msg = "Testing Recipe Id Exception";
        assertEquals(expected, invalidRecipeIdException.getMessage(), msg);
    }
}