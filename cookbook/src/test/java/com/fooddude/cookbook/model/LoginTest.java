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

    @Test
    void allArgsConstructor() throws NoSuchFieldException, IllegalAccessException {
        Login login = new Login("test_username", "test_password");

        final Field usernameField = login.getClass().getDeclaredField("username");
        usernameField.setAccessible(true);

         final Field passwordField = login.getClass().getDeclaredField("password");
         passwordField.setAccessible(true);

         String actualUsername = (String) usernameField.get(login);
        String actualPassword = (String) passwordField.get(login);

        assertEquals("test_username", actualUsername, "Testing Login all args constructor method: username does not match");
        assertEquals("test_password", actualPassword, "Testing Login all args constructor method: password does not match");


    }
}