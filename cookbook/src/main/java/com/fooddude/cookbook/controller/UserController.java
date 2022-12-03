package com.fooddude.cookbook.controller;

import com.fooddude.cookbook.exception.IncorrectPasswordException;
import com.fooddude.cookbook.exception.UserNotFoundException;
import com.fooddude.cookbook.model.Login;
import com.fooddude.cookbook.model.User;
import com.fooddude.cookbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Posts / Gets from URL = "localhost:8080/user/..."

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public User getUser(@RequestBody Login login) throws Exception {
        User user = userService.getUser(login.getUsername(), login.getPassword());
        if (user == null)
            throw new IncorrectPasswordException();
        return user;
    }

    @PostMapping("/create")
    public String createUser(@RequestBody User user) {
        userService.createUser(user);
        return "New user is created";
    }

    @PostMapping("/update")
    public String updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return "A user has been updated";
    }

} // end of UserController class
