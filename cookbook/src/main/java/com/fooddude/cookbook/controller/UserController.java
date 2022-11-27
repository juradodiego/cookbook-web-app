package com.fooddude.cookbook.controller;

import com.fooddude.cookbook.model.User;
import com.fooddude.cookbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Posts / Gets from URL = "localhost:8080/user/..."

// TODO add test class for UserController class
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public User getUser(@RequestBody String username, String password){
        return userService.getUser(username, password);
        // TODO add exception handling & throwing
    }
    @PostMapping("/create")
    public String createUser(@RequestBody User user){
        userService.createUser(user);
        return "New user is created";
    }
    @PostMapping("/update")
    public String updateUser(@RequestBody User user){
        userService.updateUser(user);
        return "A user has been updated";
    }

} // end of UserController class
