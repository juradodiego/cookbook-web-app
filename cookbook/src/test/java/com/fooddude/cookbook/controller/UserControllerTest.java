package com.fooddude.cookbook.controller;

import com.fooddude.cookbook.exception.IncorrectPasswordException;
import com.fooddude.cookbook.exception.UserNotFoundException;
import com.fooddude.cookbook.model.Login;
import com.fooddude.cookbook.model.User;
import com.fooddude.cookbook.repository.UserRepository;
import com.mysql.cj.exceptions.PasswordExpiredException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserControllerTest {

    @Autowired UserController userController;
    @Autowired UserRepository userRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    @Transactional
    void getUser() throws Exception {
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("User");
        user.setUsername("testUser");
        user.setPassword("password");
        user.setEmail("user@test.com");
        user.setSavedRecipeIds(new ArrayList<>());
        user = userRepository.save(user);

        Login login = new Login("testUser", "password");

        User actual = userController.getUser(login);

        assertEquals(user.getFirstName(), actual.getFirstName(), "Testing getUser method - firstName does not match.");
        assertEquals(user.getLastName(), actual.getLastName(), "Testing getUser method - lastName does not match.");
        assertEquals(user.getUsername(), actual.getUsername(), "Testing getUser method - username does not match.");
        assertEquals(user.getPassword(), actual.getPassword(), "Testing getUser method - password does not match.");
        assertEquals(user.getEmail(), actual.getEmail(), "Testing getUser method - email does not match.");
        assertEquals(user.getSavedRecipeIds().toString(), actual.getSavedRecipeIds().toString(), "Testing getUser method - savedRecipeIds does not match.");
    }

    @Test
    void getUserPasswordException() throws IncorrectPasswordException {
        User user = new User();
        user.setUsername("testUser");
        user.setFirstName("Test");
        user.setLastName("User");
        user.setPassword("password");
        user.setEmail("user@test.com");
        user.setSavedRecipeIds(new ArrayList<>());
        user = userRepository.save(user);

        Login login = new Login("testUser", "wrong_password");
        assertThrows(IncorrectPasswordException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                userController.getUser(login);
            }
        });
    }

    @Test
    @Transactional
    void createUser() {

        String msg = "Testing creatUser method";

        User user = new User();
        user.setUsername("testUser");
        user.setFirstName("Test");
        user.setLastName("User");
        user.setPassword("password");
        user.setEmail("user@test.com");
        user.setSavedRecipeIds(new ArrayList<>());
        user = userRepository.save(user);

        Integer userId = user.getId();

        Optional<User> resultOp = userRepository.findById(userId);
        assertTrue(resultOp.isPresent());
        User result = resultOp.get();

        String expected = "New user is created";
        String actual = userController.createUser(user);

        assertEquals(expected, actual, msg);
        assertEquals(user.getFirstName(), result.getFirstName());
        assertEquals(user.getLastName(), result.getLastName());
        assertEquals(user.getUsername(), result.getUsername());
        assertEquals(user.getPassword(), result.getPassword());
        assertEquals(user.getEmail(), result.getEmail());
        assertEquals(user.getSavedRecipeIds().toString(), result.getSavedRecipeIds().toString());

    }

    @Test
    @Transactional
    void updateUser() throws NoSuchFieldException, IllegalAccessException {
        User user = new User();
        user.setUsername("testUser");
        user.setFirstName("Test");
        user.setLastName("User");
        user.setPassword("password");
        user.setEmail("user@test.com");
        user.setSavedRecipeIds(new ArrayList<>());
        user = userRepository.save(user);
        Integer userId = user.getId();

        User orig = new User();
        final Field field = orig.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(orig, userId);
        orig.setFirstName(user.getFirstName());
        orig.setLastName(user.getLastName());
        orig.setUsername(user.getUsername());
        orig.setPassword(user.getPassword());
        orig.setEmail(user.getEmail());
        orig.setSavedRecipeIds(user.getSavedRecipeIds());

        assertNotEquals(user, orig, "Deep copy failed");

        orig.setPassword("strong_password");

        String expectedStr = "A user has been updated";
        String actualStr = userController.updateUser(orig);
        assertEquals(expectedStr, actualStr);

        User expected = orig;

        Optional<User> actualOp = userRepository.findById(userId);
        assertTrue(actualOp.isPresent());
        User actual = actualOp.get();

        assertNotEquals(expected, actual, "Referencing expected and actual are the same object");
        assertEquals(expected.getUsername(), actual.getUsername(), "Username does not match");
        assertEquals(expected.getFirstName(), actual.getFirstName(), "User firstName does not match");
        assertEquals(expected.getLastName(), actual.getLastName(), "User lastName does not match");
        assertEquals(expected.getPassword(), actual.getPassword(), "User password does not match");
        assertEquals(expected.getEmail(), actual.getEmail(), "User email does not match");
        assertEquals(expected.getSavedRecipeIds().toString(), actual.getSavedRecipeIds().toString(), "User recipes do not match");

    }
}