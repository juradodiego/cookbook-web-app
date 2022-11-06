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

        for(Recipe recipe : allRecipes)
        {
            // If ingredients don't match, break
            if(!checkIngredients(filter, recipe)){break;}

            // If appliances don't match, break
            if(!checkAppliances(filter, recipe)){break;}

            // If difficulty ratings don't match, break
            if(!checkDifficultyRating(filter, recipe)){break;}

            // If quality ratings don't match, break
            if(!checkQualityRating(filter, recipe)){break;}

            // If cuisine doesn't match, break
            if(!checkCuisine(filter, recipe)){break;}

            // If flavor doesn't match, break
            if(!checkFlavor(filter, recipe)){break;}

            // If diets don't match, break
            if(!checkDiets(filter, recipe)){break;}

            // Else add the recipe
            filteredRecipes.add(recipe);
        }

        return allRecipes;
    }

    // Method to check ingredients
    private boolean checkIngredients(Filter f, Recipe r)
    {
        // TODO
        return false;
    }

    //Method to check appliances
    private boolean checkAppliances(Filter f, Recipe r)
    {
        return isS2SubsetOfS1(f.getAppliances(), r.getAppliances());
    }

    //Method to check difficulty
    private boolean checkDifficultyRating(Filter f, Recipe r)
    {
        return r.getDifficultyRating() <= f.getDifficultyRating();
    }

    //Method to check quality
    private boolean checkQualityRating(Filter f, Recipe r){
        return r.getQualityRating() >= f.getQualityRating();
    }

    //Method to check cuisine
    private boolean checkCuisine(Filter f, Recipe r)
    {
        return f.getCuisine().equals(r.getCuisine());
    }

    //Method to check flavor
    private boolean checkFlavor(Filter f, Recipe r)
    {
        return f.getFlavor().equals(r.getFlavor());
    }

    //Method to check diets
    private boolean checkDiets(Filter f, Recipe r)
    {
        return isS2SubsetOfS1(r.getDiets(), f.getDiets());
    }

    // Utility Methods
    private static boolean isS2SubsetOfS1(String[] S1, String[] S2) {
        boolean output = true;
            for(String s2_item : S2){
                boolean hit_app = false;
                for(String s1_item : S1){
                    if(s1_item.equals(s2_item)){
                        hit_app = true;
                        break;
                    }
                }
                if(!hit_app){
                    output = false;
                    break;
                }
            }
            return output;
    }
}
