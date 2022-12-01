package com.fooddude.cookbook.model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    @Test
    void getUsername() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for username";
        final String expected = "diegojurado";
        final Login login = new Login();
        final Field field = login.getClass().getDeclaredField("username");
        field.setAccessible(true);
        field.set(login, "diegojurado");
        final String actual = login.getUsername();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getPassword() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for password";
        final String expected = "password";
        final Login login = new Login();
        final Field field = login.getClass().getDeclaredField("password");
        field.setAccessible(true);
        field.set(login, "password");
        final String actual = login.getPassword();
        assertEquals(expected, actual, msg);
    }
}