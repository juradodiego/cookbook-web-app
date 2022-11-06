package com.fooddude.cookbook.service;

import com.fooddude.cookbook.model.Filter;
import com.fooddude.cookbook.model.Recipe;
import com.fooddude.cookbook.repository.CustomRecipeRepository;
import com.fooddude.cookbook.repository.CustomRecipeRepositoryImpl;
import com.fooddude.cookbook.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public List<Recipe> getFilteredRecipes(Filter filter) {
        return recipeRepository.filteredSearch(filter);
    }


}
