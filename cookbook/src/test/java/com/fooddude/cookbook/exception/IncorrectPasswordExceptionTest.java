package com.fooddude.cookbook.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncorrectPasswordExceptionTest {

    private final String expected = "Error: Incorrect Password was Entered";
    private final IncorrectPasswordException incorrectPasswordException = new IncorrectPasswordException();

    @Test
    public void incorrectPasswordException(){
        String msg = "Testing Password Exception";
        assertEquals(expected, incorrectPasswordException.getMessage(), msg);
    }
}