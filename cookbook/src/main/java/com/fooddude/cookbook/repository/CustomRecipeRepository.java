package com.fooddude.cookbook.repository;

import com.fooddude.cookbook.exception.InvalidRecipeIdException;
import com.fooddude.cookbook.model.Filter;
import com.fooddude.cookbook.model.Recipe;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomRecipeRepository {
    Recipe findRecipeById(Integer id, List<Recipe> allRecipes) throws InvalidRecipeIdException;
    List<Recipe> findByIds(List<Integer> ids, List<Recipe> allRecipes);
    List<Recipe> filteredSearch (Filter filter, List<Recipe> allRecipes);

} // end of CustomRecipeRepository interface
