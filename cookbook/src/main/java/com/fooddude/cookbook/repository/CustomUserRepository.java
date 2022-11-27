package com.fooddude.cookbook.repository;

import com.fooddude.cookbook.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomUserRepository {
    User findByUsername(String username);

} // end of UserRepository interface
