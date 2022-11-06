package com.fooddude.cookbook.service;

import com.fooddude.cookbook.model.Recipe;

import java.util.List;

public interface RecipeService {
    public Recipe saveRecipe(Recipe recipe);
    public List<Recipe> getAllRecipes();

    // TODO add connections to React application
}
