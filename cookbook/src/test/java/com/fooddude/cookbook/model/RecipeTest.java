package com.fooddude.cookbook.model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    @Test
    void getId() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for id";
        final Integer expected = 1;
        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(recipe, 1);
        final Integer actual = recipe.getId();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getName() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for name";
        final String expected = "Omelette";
        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(recipe, "Omelette");
        final String actual = recipe.getName();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getDescription() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for name";
        final String expected = "A wonderful dish of French origin";
        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("description");
        field.setAccessible(true);
        field.set(recipe, "A wonderful dish of French origin");
        final String actual = recipe.getDescription();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getInstructions() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for instructions";
        final String[] arr = {"1. Crack a few eggs", "2. Scramble the eggs", "3. Pour eggs in pan over flame"};
        final String expected = new ArrayList<String>(List.of(arr)).toString();
        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("instructions");
        field.setAccessible(true);
        List<String> list = new ArrayList<String>(List.of(arr));
        field.set(recipe, list);
        final String actual = recipe.getInstructions().toString();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getIngredients() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for ingredients";
        final String[] i_arr = {"Eggs", "Green Peppers", "Tomatoes"};
        final String[] a_arr = {"2", "1", "1"};
        final HashMap<String, String> expected_map = new HashMap<String, String>();
        for (int i=0; i< i_arr.length; i++) expected_map.put(i_arr[i],a_arr[i]);
        String expected = expected_map.toString();
        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("ingredients");
        field.setAccessible(true);
        final HashMap<String, String> map = new HashMap<String, String>();
        for (int i=0; i< i_arr.length; i++) map.put(i_arr[i],a_arr[i]);
        field.set(recipe, map);
        final String actual = recipe.getIngredients().toString();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getAppliances() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for appliances";
        final String[] arr = {"Microwave", "Oven", "Toaster"};
        final String expected = new ArrayList<String>(List.of(arr)).toString();
        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("appliances");
        field.setAccessible(true);
        List<String> list = new ArrayList<String>(List.of(arr));
        field.set(recipe, list);
        final String actual = recipe.getAppliances().toString();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getCookTime() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for cookTime";
        final double expected = 2.2;
        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("cookTime");
        field.setAccessible(true);
        field.set(recipe, 2.2);
        final double actual = recipe.getCookTime();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getDifficultyRating() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for difficultyRating";
        final double expected = 3.7;
        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("difficultyRating");
        field.setAccessible(true);
        field.set(recipe, 3.7);
        final double actual = recipe.getDifficultyRating();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getQualityRating() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for qualityRating";
        final double expected = 4.7;
        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("qualityRating");
        field.setAccessible(true);
        field.set(recipe, 4.7);
        final double actual = recipe.getQualityRating();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getCuisine() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for cuisine";
        final String expected = "Chinese";
        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("cuisine");
        field.setAccessible(true);
        field.set(recipe, "Chinese");
        final String actual = recipe.getCuisine();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getFlavor() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for flavor";
        final String expected = "Savory";
        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("flavor");
        field.setAccessible(true);
        field.set(recipe, "Savory");
        final String actual = recipe.getFlavor();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getDiets() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for diets";
        final String[] arr = {"Kosher", "Vegetarian", "Halal"};
        final String expected = new ArrayList<String>(List.of(arr)).toString();
        final Recipe recipe = new Recipe();
        final Field field = recipe.getClass().getDeclaredField("diets");
        field.setAccessible(true);
        List<String> list = new ArrayList<String>(List.of(arr));
        field.set(recipe, list);
        final String actual = recipe.getDiets().toString();
        assertEquals(expected, actual, msg);
    }

    @Test
    void setName() {
    }

    @Test
    void setDescription() {
    }

    @Test
    void setInstructions() {
    }

    @Test
    void setIngredients() {
    }

    @Test
    void setAppliances() {
    }

    @Test
    void setCookTime() {
    }

    @Test
    void setDifficultyRating() {
    }

    @Test
    void setQualityRating() {
    }

    @Test
    void setCuisine() {
    }

    @Test
    void setFlavor() {
    }

    @Test
    void setDiets() {
    }
}