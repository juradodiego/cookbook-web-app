package com.fooddude.cookbook;

import com.fooddude.cookbook.controller.RecipeController;
import com.fooddude.cookbook.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CookbookApplicationTest {

    @Autowired
    private RecipeController recipeController;
    @Autowired
    private UserController userController;

    @Test
    public void main() {
        CookbookApplication.main(new String [] {});
    }

    @Test
    public void userContextLoads() {
        String msg = "Sanity check to test user controller context";
        assertNotEquals(userController, null, msg);
    }

    @Test
    public void recipeContextLoads() {
        String msg = "Sanity check to test recipe controller context";
        assertNotEquals(recipeController, null, msg);
    }
}