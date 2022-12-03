package com.fooddude.cookbook.repository;


import com.fooddude.cookbook.exception.InvalidRecipeIdException;
import com.fooddude.cookbook.model.Recipe;
import com.fooddude.cookbook.model.Filter;
import com.fooddude.cookbook.repository.CustomRecipeRepositoryImpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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

    Recipe recipe1 = new Recipe();
    Filter filter = new Filter();

    List<Integer> ids = new ArrayList<>();
    List<Recipe> allRecipes = new ArrayList<>();


    //    Recipe recipe2;
    ArrayList<String> diets = new ArrayList<>();
    ArrayList<String> appliances = new ArrayList<>();
    HashMap<String, String> ingredients = new HashMap<String, String>();

    ArrayList<String> filterIngredients = new ArrayList<>();

    ArrayList<String> instructions = new ArrayList<>();

    @BeforeEach
    void setUp() {


        ids.add(1);
        ids.add(2);

        ingredients.put("Spaghetti", "One box");

        diets.add("diet");

        appliances.add("pan");
        appliances.add("stove");

        instructions.add("Get pasta");
        instructions.add("Cook pasta");

        filterIngredients.add("Spaghetti");


        recipe1 = mock(Recipe.class);
        when(recipe1.getFlavor()).thenReturn("Good");
        when(recipe1.getAppliances()).thenReturn(appliances);
        when(recipe1.getName()).thenReturn("Spachetti");
        when(recipe1.getDiets()).thenReturn(diets);
        when(recipe1.getCuisine()).thenReturn("Italian");
        when(recipe1.getIngredients()).thenReturn(ingredients);
        when(recipe1.getDifficultyRating()).thenReturn(3.0);
        when(recipe1.getCookTime()).thenReturn(10.0);
        when(recipe1.getInstructions()).thenReturn(instructions);
        when(recipe1.getId()).thenReturn(1);
        when(recipe1.getQualityRating()).thenReturn(4.0);

        filter = mock(Filter.class);
        when(filter.getAppliances()).thenReturn(appliances);
        when(filter.getIngredients()).thenReturn(filterIngredients);
        when(filter.getQualityRating()).thenReturn(4.0);
        when(filter.getFlavor()).thenReturn("Good");
        when(filter.getCuisine()).thenReturn("Italian");
        when(filter.getDiets()).thenReturn(diets);
        when(filter.getDifficultyRating()).thenReturn(3.0);

        allRecipes.add(recipe1);


//
//        recipe1.setName("Spaghetti");
//        recipe1.setFlavor("Good");
//        recipe1.setDiets(diets);
//        recipe1.setCuisine("Italian");
//        recipe1.setAppliances(appliances);
//        recipe1.setIngredients(ingredients);
//        recipe1.setDifficultyRating(3);
//        recipe1.setCookTime(10);
//        recipe1.setInstructions(instructions);

        //How to set the ID of this?

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void findRecipeByIdMatchTest() throws InvalidRecipeIdException, NoSuchFieldException {

        String msg = "FindRecipeById when ids match";
        Recipe actual;
        //final Field field = recipe1.getClass().getDeclaredField("id");
        //field.setAccessible(true);
        actual = recipeRepository.findRecipeById(1, allRecipes);


        assertEquals(recipe1.getId(), actual.getId(), msg);

    }

    @Test
    void findRecipeByIdTestNoMatchTest() throws InvalidRecipeIdException {
        String msg = "FindRecipeById when ids do NOT match";
        assertNull(recipeRepository.findRecipeById(2, allRecipes), msg);

    }

    @Test
    void findByIdsMatchTest() {
        List<Recipe> newRecipes = new ArrayList<>();

        newRecipes = recipeRepository.findByIds(ids, allRecipes);
        String msg = "findByIds when there are some ID matches";

        assertEquals(1, newRecipes.size(), msg);


    }

    @Test
    void findByIdsNoMatchTest() {
        List<Recipe> newRecipes = recipeRepository.findByIds(null, allRecipes);
        String msg = "findByIds when there are no ID matches";

        assertEquals(0, newRecipes.size(), msg);
    }

    @Test
    void filteredSearchFilterAndRecipeMatchTest() {
        String msg = "filteredSearch when the recipe contains all the same things as filter";

        List<Recipe> filterRecipes = new ArrayList<>();
        filterRecipes = recipeRepository.filteredSearch(filter, allRecipes);

        assertEquals(1, filterRecipes.size(), msg);

    }
}