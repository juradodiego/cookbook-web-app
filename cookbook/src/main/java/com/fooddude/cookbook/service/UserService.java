package com.fooddude.cookbook.service;

import com.fooddude.cookbook.exception.UserNotFoundException;
import com.fooddude.cookbook.model.User;

public interface UserService {
    public User getUser(String username, String password) throws UserNotFoundException;
    public User createUser(User user);
    public User updateUser(User user);

} // end of UserService interface
