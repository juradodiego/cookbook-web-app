package com.fooddude.cookbook.service;

import com.fooddude.cookbook.model.Filter;
import com.fooddude.cookbook.model.Recipe;

import java.util.List;

public interface RecipeService {
    public Recipe saveRecipe(Recipe recipe);
    public List<Recipe> getAllRecipes();
    public List<Recipe> getFilteredRecipes(Filter filter);

}
