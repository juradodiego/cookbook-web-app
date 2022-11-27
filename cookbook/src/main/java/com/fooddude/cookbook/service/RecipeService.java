package com.fooddude.cookbook.service;

import com.fooddude.cookbook.model.Filter;
import com.fooddude.cookbook.model.Recipe;

import java.util.List;

public interface RecipeService {
    public List<Recipe> getAllRecipes();
    public List<Recipe> getFilteredRecipes(Filter filter);
    public List<Recipe> getRecipesByIds(List<Integer> ids);
    public Recipe addRecipe(Recipe recipe);
    public void deleteRecipe(Recipe recipe);

}
