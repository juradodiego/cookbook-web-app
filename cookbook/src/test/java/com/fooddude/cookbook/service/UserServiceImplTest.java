package com.fooddude.cookbook.service;

import com.fooddude.cookbook.exception.UserNotFoundException;
import com.fooddude.cookbook.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    void getUser() throws UserNotFoundException {
        String msg = "Testing getUser method";
        String expected = "diegojurado";
        User user = userService.getUser("diegojurado", "strong_password");
        String actual = user.getUsername();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getUserFail() throws UserNotFoundException {
        String msg = "Testing getUser method - Test Case: username was valid was found but password was not valid";
        assertNull(userService.getUser("diegojurado", "password"));
    }

    @Test
    void userNotFound() throws UserNotFoundException {
        String msg = "Testing getUser method - Test Case: Username not found";
        assertThrows(UserNotFoundException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                userService.getUser("user_not_found", "password");
            }
        });
    }

    @Test
    void createUser() {
    }

    @Test
    void updateUser() {
    }
}