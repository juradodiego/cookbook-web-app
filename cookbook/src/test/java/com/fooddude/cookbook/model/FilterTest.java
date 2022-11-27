package com.fooddude.cookbook.model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterTest {

    @Test
    void getIngredients() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for ingredients";
        final String[] arr = {"Eggs", "Green Peppers", "Tomatoes"};
        final String expected = new ArrayList<String>(List.of(arr)).toString();
        final Filter filter = new Filter();
        final Field field = filter.getClass().getDeclaredField("ingredients");
        field.setAccessible(true);
        List<String> list = new ArrayList<String>(List.of(arr));
        field.set(filter, list);
        final String actual = filter.getIngredients().toString();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getAppliances() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for appliances";
        final String[] arr = {"Microwave", "Oven", "Toaster"};
        final String expected = new ArrayList<String>(List.of(arr)).toString();
        final Filter filter = new Filter();
        final Field field = filter.getClass().getDeclaredField("appliances");
        field.setAccessible(true);
        List<String> list = new ArrayList<String>(List.of(arr));
        field.set(filter, list);
        final String actual = filter.getAppliances().toString();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getDifficultyRating() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for difficultyRating";
        final double expected = 3.7;
        final Filter filter = new Filter();
        final Field field = filter.getClass().getDeclaredField("difficultyRating");
        field.setAccessible(true);
        field.set(filter, 3.7);
        final double actual = filter.getDifficultyRating();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getQualityRating() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for qualityRating";
        final double expected = 4.7;
        final Filter filter = new Filter();
        final Field field = filter.getClass().getDeclaredField("qualityRating");
        field.setAccessible(true);
        field.set(filter, 4.7);
        final double actual = filter.getQualityRating();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getCuisine() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for cuisine";
        final String expected = "Chinese";
        final Filter filter = new Filter();
        final Field field = filter.getClass().getDeclaredField("cuisine");
        field.setAccessible(true);
        field.set(filter, "Chinese");
        final String actual = filter.getCuisine();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getFlavor() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for flavor";
        final String expected = "Savory";
        final Filter filter = new Filter();
        final Field field = filter.getClass().getDeclaredField("flavor");
        field.setAccessible(true);
        field.set(filter, "Savory");
        final String actual = filter.getFlavor();
        assertEquals(expected, actual, msg);
    }

    @Test
    void getDiets() throws NoSuchFieldException, IllegalAccessException {
        final String msg = "Testing Getter method for diets";
        final String[] arr = {"Kosher", "Vegetarian", "Halal"};
        final String expected = new ArrayList<String>(List.of(arr)).toString();
        final Filter filter = new Filter();
        final Field field = filter.getClass().getDeclaredField("diets");
        field.setAccessible(true);
        List<String> list = new ArrayList<String>(List.of(arr));
        field.set(filter, list);
        final String actual = filter.getDiets().toString();
        assertEquals(expected, actual, msg);
    }

    @Test
    void setIngredients() {
    }

    @Test
    void setAppliances() {
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