package com.fooddude.cookbook.controller;

import com.fooddude.cookbook.exception.InvalidRecipeIdException;
import com.fooddude.cookbook.model.Filter;
import com.fooddude.cookbook.model.Recipe;
import com.fooddude.cookbook.repository.RecipeRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;


import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RecipeControllerTest {

    @Autowired RecipeController recipeController;
    @Autowired RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {


    }

    @AfterEach
    void tearDown() {
        recipeRepository.deleteAll();
    }
    @Test
    @Transactional
    void getRecipeTest() throws InvalidRecipeIdException {

        recipeRepository.deleteAll();

        HashMap<String, String> ingredients = new HashMap<>();
        List<String> appliances = new ArrayList<>();
        List<String> filterIngredients = new ArrayList<>();
        List<String> diets = new ArrayList<>();

        ingredients.put("Pasta", "One");
        filterIngredients.add("Pasta");
        appliances.add("Stove");
        diets.add("Diet");



        Recipe recipe = new Recipe();
        recipe.setAppliances(appliances);
        recipe.setFlavor("Good");
        recipe.setIngredients(ingredients);
        recipe.setDiets(diets);
        recipe.setCuisine("Italian");
        recipe.setQualityRating(3.0);
        recipe.setDifficultyRating(2.0);

        recipe = recipeRepository.save(recipe);

        String msg = "Testing getRecipe method";

        Integer actual = (recipeController.getRecipe(recipe.getId())).getId();

        assertEquals(recipe.getId(), actual, msg);
        assertEquals(recipe.getAppliances(), (recipeController.getRecipe(recipe.getId())).getAppliances(), msg);
        assertEquals(recipe.getFlavor(), (recipeController.getRecipe(recipe.getId())).getFlavor(), msg);
        assertEquals(recipe.getIngredients(), (recipeController.getRecipe(recipe.getId())).getIngredients(), msg);
        assertEquals(recipe.getDiets(), (recipeController.getRecipe(recipe.getId())).getDiets(), msg);
        assertEquals(recipe.getCuisine(), (recipeController.getRecipe(recipe.getId())).getCuisine(), msg);
        assertEquals(recipe.getQualityRating(), (recipeController.getRecipe(recipe.getId())).getQualityRating(), msg);
        assertEquals(recipe.getDifficultyRating(), (recipeController.getRecipe(recipe.getId())).getDifficultyRating(), msg);

    }

    @Test
    void getRecipeInvalidIdTest() throws InvalidRecipeIdException {



        String msg = "Testing getRecipe with an invalid id";
        assertThrows(InvalidRecipeIdException.class, new Executable() {
            @Override
            public void execute() throws Throwable{
                recipeController.getRecipe(0);
            }

        }, msg);
    }



    @Test
    void getAllRecipesTest() {
        recipeRepository.deleteAll();

        for(int i = 0; i < 100; i++){
            recipeRepository.save(new Recipe());
        }

        String msg = "Testing get all recipes";
        int expected = 100;
        int actual = (recipeController.getAllRecipes()).size();

        assertEquals(expected, actual, msg);
    }

    @Test
    @Transactional
    void getFilteredRecipesMatchTest() {

        recipeRepository.deleteAll();

        HashMap<String, String> ingredients = new HashMap<>();
        List<String> appliances = new ArrayList<>();
        List<String> filterIngredients = new ArrayList<>();
        List<String> diets = new ArrayList<>();

        ingredients.put("Pasta", "One");
        filterIngredients.add("Pasta");
        appliances.add("Stove");
        diets.add("Diet");



        Recipe recipe = new Recipe();
        recipe.setAppliances(appliances);
        recipe.setFlavor("Good");
        recipe.setIngredients(ingredients);
        recipe.setDiets(diets);
        recipe.setCuisine("Italian");
        recipe.setQualityRating(3.0);
        recipe.setDifficultyRating(2.0);

        recipe = recipeRepository.save(recipe);

        Filter filter = new Filter();
        filter.setAppliances(appliances);
        filter.setFlavor("Good");
        filter.setIngredients(filterIngredients);
        filter.setDiets(diets);
        filter.setCuisine("Italian");
        filter.setQualityRating(3.0);
        filter.setDifficultyRating(2.0);

        String msg = "Testing getFilteredRecipes one match in the filter and recipes";
        int actual = (recipeController.getFilteredRecipes(filter)).size();
        int expected = 1;

        assertEquals(expected, actual, msg);
    }

    @Test
    void getFilteredRecipesNoMatchTest(){
        HashMap<String, String> ingredients = new HashMap<>();
        List<String> appliances = new ArrayList<>();
        List<String> filterIngredients = new ArrayList<>();
        List<String> diets = new ArrayList<>();

        ingredients.put("Pasta", "One");
        filterIngredients.add("Pasta");
        appliances.add("Stove");
        diets.add("Diet");

        Filter filter = new Filter();
        filter.setAppliances(appliances);
        filter.setFlavor("Good");
        filter.setIngredients(filterIngredients);
        filter.setDiets(diets);
        filter.setCuisine("Italian");
        filter.setQualityRating(3.0);
        filter.setDifficultyRating(2.0);

        String msg = "Testing getFilteredRecipes no matches in the filter and recipes";
        int actual = (recipeController.getFilteredRecipes(filter)).size();
        int expected = 0;

        assertEquals(expected, actual, msg);



    }
    @Test
    void getRecipesByIdsTest() {
        Recipe recipe1 = new Recipe();
        recipe1 = recipeRepository.save(recipe1);
        int recipe1Id = recipe1.getId();
        List<Integer> ids = new ArrayList<>();
        ids.add(recipe1Id);

        int actual = (recipeController.getRecipesByIds(ids)).size();
        int expected = 1;

        String msg = "Testing getRecipesByIds when there is 1 id match";

        assertEquals(expected, actual, msg);
        List<Integer> noValidIds = new ArrayList<>();
        noValidIds.add(1000202);
        actual = (recipeController.getRecipesByIds(noValidIds).size());
        expected = 0;
        msg = "testing getRecipesByIds when there are no id matches";

        assertEquals(expected, actual, msg);

    }


    @Test
    void addRecipeTest() {
        recipeRepository.deleteAll();
        Recipe recipe1 = new Recipe();
        String actual = recipeController.addRecipe(recipe1);

        String expected ="New recipe is added";
        String msg = "Testing addRecipe with one added recipe";

        assertEquals(expected, actual, msg);
    }

    @Test
    void deleteRecipe() throws InvalidRecipeIdException {

        recipeRepository.deleteAll();

        for(int i = 0; i < 100; i++){
            recipeRepository.save(new Recipe());
        }

        Recipe recipe1 = new Recipe();
        recipe1 = recipeRepository.save(recipe1);

        int expected = 101;
        int actual = recipeRepository.findAll().size();

        String msg = "Size before deleting 1 recipe";

        assertEquals(expected, actual, msg);

        expected = 100;
        String strActual = recipeController.deleteRecipe(recipe1.getId());
        actual = recipeRepository.findAll().size();
        msg = "Size after deleting 1 recipe";

        assertEquals(expected, actual, msg);

        String strExpected = "A recipe has been deleted";
        msg = "Assuring the correct message is returned from the message";

        assertEquals(strExpected, strActual, msg);
    }

    @Test
    void deleteRecipeExceptionThrownTest() throws InvalidRecipeIdException{
        String msg = "Testing when InvalidRecipeIdException is thrown";
        assertThrows(InvalidRecipeIdException.class, new Executable() {
            @Override
            public void execute() throws Throwable{
                recipeController.deleteRecipe(0);
            }

        }, msg);

    }
}