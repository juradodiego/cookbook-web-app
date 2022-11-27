package com.fooddude.cookbook.controller;

import com.fooddude.cookbook.model.User;
import com.fooddude.cookbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public User get(@RequestBody String username, String password){
        return userService.getUser(username, password);
        // TODO add exception handling & throwing
    }

    @PostMapping("/create")
    public String create(@RequestBody User user){
        userService.createUser(user);
        return "New user is created";
    }

    @PostMapping("/update")
    public String update(@RequestBody User user){
        userService.updateUser(user);
        return "A user has been updated";
    }
}
