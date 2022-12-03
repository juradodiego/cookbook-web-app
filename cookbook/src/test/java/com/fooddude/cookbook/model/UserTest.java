package com.fooddude.cookbook.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getId() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for id";
        final Integer expected = 1;
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(user, 1);
        final Integer actual = user.getId();
        assertEquals(expected, actual, msg);

    }

    @Test
    void getFirstName() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for firstName";
        final String expected = "Diego";
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        field.set(user, "Diego");
        final String actual = user.getFirstName();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getLastName() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for lastName";
        final String expected = "Jurado";
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        field.set(user, "Jurado");
        final String actual = user.getLastName();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getUsername() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for username";
        final String expected = "juradodiego";
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("username");
        field.setAccessible(true);
        field.set(user, "juradodiego");
        final String actual = user.getUsername();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getEmail() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for email";
        final String expected = "diego.jurado@pitt.edu";
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("email");
        field.setAccessible(true);
        field.set(user, "diego.jurado@pitt.edu");
        final String actual = user.getEmail();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getPassword() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for password";
        final String expected = "strong_password";
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("password");
        field.setAccessible(true);
        field.set(user, "strong_password");
        final String actual = user.getPassword();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getSavedRecipeIds() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for savedRecipeIds";
        final List<Integer> expected = new ArrayList<Integer>();
        for (int i = 0; i < 10; i += 2)
            expected.add(i);
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("savedRecipeIds");
        field.setAccessible(true);
        final List<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < 10; i += 2)
            arr.add(i);
        field.set(user, arr);
        final List<Integer> actual = user.getSavedRecipeIds();
        assertEquals(expected, actual, msg);

    }

    @Test
    void setFirstName() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Setter Method for firstName";
        final String expected = "Diego";
        final User user = new User();
        user.setFirstName("Diego");
        final Field field = user.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        assertEquals(expected, field.get(user), msg);

    }

    @Test
    void setLastName() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Setter Method for lastName";
        final String expected = "Jurado";
        final User user = new User();
        user.setLastName("Jurado");
        final Field field = user.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        assertEquals(expected, field.get(user), msg);
    }

    @Test
    void setUsername() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Setter Method for username";
        final String expected = "juradodiego";
        final User user = new User();
        user.setUsername("juradodiego");
        final Field field = user.getClass().getDeclaredField("username");
        field.setAccessible(true);
        assertEquals(expected, field.get(user), msg);
    }

    @Test
    void setEmail() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Setter Method for email";
        final String expected = "diego.jurado@pitt.edu";
        final User user = new User();
        user.setEmail("diego.jurado@pitt.edu");
        final Field field = user.getClass().getDeclaredField("email");
        field.setAccessible(true);
        assertEquals(expected, field.get(user), msg);
    }

    @Test
    void setPassword() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Setter Method for password";
        final String expected = "strong_password";
        final User user = new User();
        user.setPassword("strong_password");
        final Field field = user.getClass().getDeclaredField("password");
        field.setAccessible(true);
        assertEquals(expected, field.get(user), msg);
    }

    @Test
    void setSavedRecipeIds() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Setter Method for savedRecipeIds";
        final List<Integer> expected = new ArrayList<Integer>();
        for (int i = 0; i < 10; i += 2)
            expected.add(i);
        final User user = new User();
        final List<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < 10; i += 2)
            arr.add(i);
        user.setSavedRecipeIds(arr);
        final Field field = user.getClass().getDeclaredField("savedRecipeIds");
        field.setAccessible(true);
        assertEquals(expected, field.get(user), msg);
    }
}