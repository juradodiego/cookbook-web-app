package com.fooddude.cookbook.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserNotFoundExceptionTest {

    @Test
    public void userNotFoundException() throws UserNotFoundException {
        String username = "juradodiego";
        String msg = "Testing User Not Found Exception";
        String expected = "Error: User -> juradodiego not found.";
        UserNotFoundException userNotFoundException = new UserNotFoundException(username);
        String actual = userNotFoundException.getMessage();
        assertEquals(expected, actual, msg);
    }

}