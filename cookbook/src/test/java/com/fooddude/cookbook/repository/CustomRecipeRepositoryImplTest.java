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



import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class CustomRecipeRepositoryImplTest {
    @Autowired
    CustomRecipeRepository recipeRepository;

    private List<Recipe> allRecipes;
    private Filter filter;
    private Recipe recipeFull;
    HashMap<String, String> ingredients;
    List<String> appliances;
    List<String> filterIngredients;
    List<String> diets;



    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {

        filter = new Filter();
        recipeFull = new Recipe();

        allRecipes = new ArrayList<>();

        ingredients = new HashMap<>();
        appliances = new ArrayList<>();
        filterIngredients = new ArrayList<>();
        diets = new ArrayList<>();

        ingredients.put("Pasta", "One");
        filterIngredients.add("Pasta");
        appliances.add("Stove");
        diets.add("Diet");

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

        filter.setAppliances(appliances);
        filter.setFlavor("Good");
        filter.setIngredients(filterIngredients);
        filter.setDiets(diets);
        filter.setCuisine("Italian");
        filter.setQualityRating(3.0);
        filter.setDifficultyRating(2.0);


        recipeFull.setAppliances(appliances);
        recipeFull.setFlavor("Good");
        recipeFull.setIngredients(ingredients);
        recipeFull.setDiets(diets);
        recipeFull.setCuisine("Italian");
        recipeFull.setQualityRating(3.0);
        recipeFull.setDifficultyRating(2.0);





    }

    @AfterEach
    void tearDown() {
        allRecipes.clear();

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
    void findByIdsTest() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);

        String msg = "Test findByIds - Test Case: 2 ids match";
        Integer actual = recipeRepository.findByIds(ids, allRecipes).size();

        assertEquals(2, actual, msg);


        ids.add(3);
        msg = "Test findByIds = Test case: all ids in allRecipes match";
        actual = recipeRepository.findByIds(ids, allRecipes).size();

        assertEquals(3, actual, msg);


        ids.remove(2); //remove index 1 ( id: 3 )
        ids.remove(1);
        msg = "Test findByIds - Test Case: 1 id matches";
        actual = recipeRepository.findByIds(ids, allRecipes).size();

        assertEquals(1, actual, msg);


        ids.remove(0);
        msg = "Test findByIds = Test Case: NO id Matches";
        actual = recipeRepository.findByIds(ids, allRecipes).size();

        assertEquals(0, actual, msg);
    }


    @Test
    void filteredSearchFilterAndRecipeMatchTest() {



        allRecipes.clear();

        allRecipes.add(recipeFull);

        int actual;

        String msg = "Test filteredSearch = Test Case: filter matches one recipe";

        actual = recipeRepository.filteredSearch(filter, allRecipes).size();

        assertEquals(1, actual, msg);

    }
    @Test
    void filteredSearchCuisineMismatchTest(){
        String msg = "Test filteredSearch - Test case Filter and recipe don't match, different Cuisine";
        filter.setCuisine("German");
        int actual = recipeRepository.filteredSearch(filter, allRecipes).size();

        assertEquals(0, actual, msg);
    }
    @Test
    void filteredSearchFlavorMismatchTest(){

        allRecipes.clear();

        allRecipes.add(recipeFull);

        String msg = "Test filteredSearch - Test case filter and recipe don't match, different Flavor";

        filter.setFlavor("Bad");
        int actual = recipeRepository.filteredSearch(filter, allRecipes).size();

        assertEquals(0, actual, msg);

    }

    @Test
    void filteredSearchDifficultyRatingMismatchTest(){
        allRecipes.clear();

        allRecipes.add(recipeFull);
        String msg = "Test filteredSearch - Test case filter and recipe don't match, different Difficulty Rating";
        filter.setDifficultyRating(10.0);
        int actual = recipeRepository.filteredSearch(filter, allRecipes).size();

        assertEquals(0, actual, msg);

    }

    @Test
    void filteredSearchQualityRatingMismatchTest(){
        allRecipes.clear();

        allRecipes.add(recipeFull);
        String msg = "Test filteredSearch - Test case filter and recipe don't match, different Quality Rating";
        filter.setQualityRating(9.0);
        int actual = recipeRepository.filteredSearch(filter, allRecipes).size();

        assertEquals(0, actual, msg);
    }

    @Test
    void filteredSearchAppliancesMismatchTest(){
        allRecipes.clear();

        allRecipes.add(recipeFull);

        String msg = "Test filteredSearch - Test case filter and recipe don't match, different Appliances";
        List<String> wrongAppliance = new ArrayList<>();
        wrongAppliance.add("Wood fire");
        filter.setAppliances(wrongAppliance);

        int actual = recipeRepository.filteredSearch(filter, allRecipes).size();

        assertEquals(0, actual, msg);
    }

    @Test
    void filteredSearchDietsMismatchTest(){
        allRecipes.clear();

        allRecipes.add(recipeFull);
        String msg = "Test filteredSearch - Test case filter and recipe don't match, different Diets";

        List<String> wrongDiets = new ArrayList<>();
        wrongDiets.add("Very Unhealthy");
        filter.setDiets(wrongDiets);
        int actual = recipeRepository.filteredSearch(filter, allRecipes).size();

        assertEquals(0, actual, msg);

    }

    @Test
    void filteredSearchIngredientsMisMatchTest(){
        allRecipes.clear();

        allRecipes.add(recipeFull);

        String msg = "Test filteredSearch - Test case filter and recipe don't match, different Ingredients";

        List<String> wrongIngredients = new ArrayList<>();
        wrongIngredients.add("Giant Rat");
        filter.setIngredients(wrongIngredients);
        int actual = recipeRepository.filteredSearch(filter, allRecipes).size();

        assertEquals(0, actual, msg);

    }
}