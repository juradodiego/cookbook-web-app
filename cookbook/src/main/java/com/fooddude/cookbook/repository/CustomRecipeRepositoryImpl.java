package com.fooddude.cookbook.repository;

import com.fooddude.cookbook.model.Filter;
import com.fooddude.cookbook.model.Recipe;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class CustomRecipeRepositoryImpl implements CustomRecipeRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Recipe> filteredSearch(Filter filter) {
        // TODO Implement Filtered Search
        return null;
    }
}
