package com.fooddude.cookbook.repository;

import com.fooddude.cookbook.exception.UserNotFoundException;
import com.fooddude.cookbook.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomUserRepositoryImplTest {

    private List<User> allUsers;

    @Autowired
    CustomUserRepository userRepository;

    @BeforeEach
    void setUp() {

        allUsers = new ArrayList<>();

        User testUser1 = new User();
        testUser1.setUsername("username1");

        User testUser2 = new User();
        testUser2.setUsername("username2");

        User testUser3 = new User();
        testUser3.setUsername("username3");

        allUsers.add(testUser1);
        allUsers.add(testUser2);
        allUsers.add(testUser3);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByUsername() {

        String msg = "Testing findByUsername method - Test Case: accessing user in the front of the list";
        String expected = "username1";
        String actual = userRepository.findByUsername("username1", allUsers).getUsername();
        assertEquals(expected, actual, msg);

        msg = "Testing findByUsername method - Test Case: accessing user in the middle of a list";
        expected = "username2";
        actual = userRepository.findByUsername("username2", allUsers).getUsername();
        assertEquals(expected, actual, msg);

        msg = "Testing findByUsername method - Test Case: accessing user at end of list";
        expected = "username3";
        actual = userRepository.findByUsername("username3", allUsers).getUsername();
        assertEquals(expected, actual, msg);

    }

    @Test
    void findByUsernameFail(){
        String msg = "Testing findByUsername method - Test Case: not finding username";
        assertNull(userRepository.findByUsername("fail", allUsers), msg);
    }
}