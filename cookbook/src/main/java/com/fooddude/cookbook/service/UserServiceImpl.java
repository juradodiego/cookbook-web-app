package com.fooddude.cookbook.service;

import com.fooddude.cookbook.model.User;
import com.fooddude.cookbook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User getUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        // TODO add exception throw if user is not detected
        return authorizeLogin(user, password) ? user : null;
        // TODO add exception throw if user is not returned
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
    private boolean authorizeLogin(User user, String password){
        // TODO add more security elements
        return password.equals(user.getPassword());
    }
}