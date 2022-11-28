package com.fooddude.cookbook.repository;

import com.fooddude.cookbook.model.User;

import java.util.List;

public class CustomUserRepositoryImpl implements CustomUserRepository{
    @Override
    public User findByUsername(String username, List<User> allUsers) {
        // TODO test method
        for (User user : allUsers)
            userMap.put(user.getUsername(), user);

        return userMap.get(username);
    }

} // end of CustomUserRepositoryImpl class
