package com.fooddude.cookbook.repository;

import com.fooddude.cookbook.model.Filter;
import com.fooddude.cookbook.model.Recipe;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


public class CustomRecipeRepositoryImpl implements CustomRecipeRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Recipe> filteredSearch(Filter filter, List<Recipe> allRecipes) {
        List<Recipe> filteredRecipes = new ArrayList<Recipe>();
        // TODO Implement Filtered Search
        return allRecipes;
    }
}
