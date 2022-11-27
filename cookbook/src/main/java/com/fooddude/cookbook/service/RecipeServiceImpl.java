package com.fooddude.cookbook.service;

import com.fooddude.cookbook.model.Filter;
import com.fooddude.cookbook.model.Recipe;
import com.fooddude.cookbook.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService{
    @Autowired
    private RecipeRepository recipeRepository;
    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
    @Override
    public List<Recipe> getFilteredRecipes(Filter filter) {
        return recipeRepository.filteredSearch(filter, getAllRecipes());
    }
    @Override
    public List<Recipe> getRecipesByIds(List<Integer> ids) {
        return recipeRepository.findByIds(ids);
    }
    @Override
    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
    @Override
    public void deleteRecipe(Recipe recipe) {
        recipeRepository.delete(recipe);
    }

} // end of RecipeServiceImpl class
