package com.fooddude.cookbook.repository;

import com.fooddude.cookbook.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface CustomUserRepository {
    User findByUsername(String username, List<User> allUsers);

} // end of UserRepository interface
