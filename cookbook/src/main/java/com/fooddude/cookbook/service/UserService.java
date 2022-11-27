package com.fooddude.cookbook.service;

import com.fooddude.cookbook.model.User;

import java.util.HashMap;

public interface UserService {
    public User getUser(String username, String password);
    public User createUser(User user);
    public User updateUser(User user);

    // TODO add new friend
    // TODO update settings

}
