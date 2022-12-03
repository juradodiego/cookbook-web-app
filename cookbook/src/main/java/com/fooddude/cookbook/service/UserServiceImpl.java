package com.fooddude.cookbook.service;

import com.fooddude.cookbook.exception.UserNotFoundException;
import com.fooddude.cookbook.model.User;
import com.fooddude.cookbook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User getUser(String username, String password) throws UserNotFoundException {
        User user = userRepository.findByUsername(username, userRepository.findAll());
        if (user == null) throw new UserNotFoundException(username);
        return authorizeLogin(user, password) ? user : null;
    }
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public User updateUser(User updatedUser) {
        Optional<User> userOp = userRepository.findById(updatedUser.getId());
        User user = userOp.get();
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        user.setSavedRecipeIds(updatedUser.getSavedRecipeIds());

        return user;
    }
    private boolean authorizeLogin(User user, String password){
        return password.equals(user.getPassword());
    }

} // end of UserServiceImpl class
