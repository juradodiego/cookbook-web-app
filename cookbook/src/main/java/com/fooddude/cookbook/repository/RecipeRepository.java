package com.fooddude.cookbook.repository;

import com.fooddude.cookbook.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer>, CustomRecipeRepository {


}
