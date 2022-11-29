package com.fooddude.cookbook.repository;

import com.fooddude.cookbook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, CustomUserRepository{

} // end of UserRepository interface
