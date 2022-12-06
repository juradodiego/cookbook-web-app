package com.fooddude.cookbook;

import com.fooddude.cookbook.controller.RecipeController;
import com.fooddude.cookbook.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CookbookApplication {
    public static void main(String[] args) {
        SpringApplication.run(CookbookApplication.class, args);

    }
} // end of CookbookApplication class