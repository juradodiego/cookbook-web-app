package com.fooddude.cookbook.repository;

import com.fooddude.cookbook.model.Filter;
import com.fooddude.cookbook.model.Recipe;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomRecipeRepository {
    List<Recipe> findByIds(List<Integer> ids);
    List<Recipe> filteredSearch (Filter filter, List<Recipe> allRecipes);
}
