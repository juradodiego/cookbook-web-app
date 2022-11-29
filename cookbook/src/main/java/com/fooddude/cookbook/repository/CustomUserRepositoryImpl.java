package com.fooddude.cookbook.repository;

import com.fooddude.cookbook.model.User;

import java.util.List;

public class CustomUserRepositoryImpl implements CustomUserRepository{
    @Override
    public User findByUsername(String username, List<User> allUsers) {
        for (User user : allUsers)
            if (username.equals(user.getUsername()))
                return user;
        return null;
    }

} // end of CustomUserRepositoryImpl class
