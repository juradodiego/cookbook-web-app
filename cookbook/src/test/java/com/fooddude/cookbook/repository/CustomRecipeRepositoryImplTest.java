package com.fooddude.cookbook.repository;


import com.fooddude.cookbook.exception.InvalidRecipeIdException;
import com.fooddude.cookbook.model.Recipe;
import com.fooddude.cookbook.model.Filter;
import com.fooddude.cookbook.repository.CustomRecipeRepositoryImpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
class CustomRecipeRepositoryImplTest {
    @Autowired
    CustomRecipeRepository recipeRepository;

    private List<Recipe> allRecipes;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {

        allRecipes = new ArrayList<>();

        Recipe recipe1 = new Recipe();
        final Field field1 = recipe1.getClass().getDeclaredField("id");
        field1.setAccessible(true);
        field1.set(recipe1, 1);
        allRecipes.add(recipe1);

        Recipe recipe2 = new Recipe();
        final Field field2 = recipe2.getClass().getDeclaredField("id");
        field2.setAccessible(true);
        field2.set(recipe2, 2);
        allRecipes.add(recipe2);

        Recipe recipe3 = new Recipe();
        final Field field3 = recipe3.getClass().getDeclaredField("id");
        field3.setAccessible(true);
        field3.set(recipe3, 3);
        allRecipes.add(recipe3);


    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void findRecipeByIdMatchTest() {
        String msg = "Testing findRecipeById method - Test Case: finding id at front of the list";
        Integer expected = 1;
        Integer actual = recipeRepository.findRecipeById(1, allRecipes).getId();
        assertEquals(expected, actual, msg);

        msg = "Testing findRecipeById method - Test Case: finding id at middle of the list";
        expected = 2;
        actual = recipeRepository.findRecipeById(2, allRecipes).getId();
        assertEquals(expected, actual, msg);

        msg = "Testing findRecipeById method - Test Case: finding id at back of the list";
        expected = 3;
        actual = recipeRepository.findRecipeById(3, allRecipes).getId();
        assertEquals(expected, actual, msg);
    }

    @Test
    void findRecipeByIdTestNoMatchTest() {
        String msg = "Testing findRecipeById method - Test Case: id not found";
        assertNull(recipeRepository.findRecipeById(0, allRecipes));

    }

    @Test
    @Disabled
    void findByIdsMatchTest() {


    }

    @Test
    @Disabled
    void findByIdsNoMatchTest() {

    }

    @Test
    @Disabled
    void filteredSearchFilterAndRecipeMatchTest() {


    }
}