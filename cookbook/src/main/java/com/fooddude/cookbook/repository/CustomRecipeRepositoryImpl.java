package com.fooddude.cookbook.repository;

import com.fooddude.cookbook.model.Filter;
import com.fooddude.cookbook.model.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class CustomRecipeRepositoryImpl implements CustomRecipeRepository{
    @Override
    public Recipe findRecipeById(Integer id, List<Recipe> allRecipes){
		for (Recipe recipe : allRecipes)
            if (id.equals(recipe.getId()))
                return recipe;
        return null;
    }
    @Override
    public List<Recipe> findByIds(List<Integer> ids, List<Recipe> allRecipes) {
		// TODO program action in scenario where not all ids are collected
		List<Recipe> recipes = new ArrayList<>();
		for (Recipe recipe : allRecipes)
			if(ids.contains(recipe.getId()))
				recipes.add(recipe);
        return recipes;
    }
    @Override
    public List<Recipe> filteredSearch(Filter filter, List<Recipe> allRecipes) {
        List<Recipe> filteredRecipes = new ArrayList<>();
        // FIXME refactor all String[] to List<String>
        // TODO implement if filter has property x, then check recipe for property x

        for(Recipe recipe : allRecipes)
        {
        	// If ingredients don't match, break
        	if(!checkIngredients(filter, recipe)){continue;}

        	// If appliances don't match, break
        	if(!checkAppliances(filter, recipe)){continue;}
        	
        	// If difficulty ratings don't match, break
        	if(!checkDifficultyRating(filter, recipe)){continue;}
        	
        	// If quality ratings don't match, break
        	if(!checkQualityRating(filter, recipe)){continue;}
        	
        	// If cuisine doesn't match, break
        	if(!checkCuisine(filter, recipe)){continue;}

        	// If flavor doesn't match, break
        	if(!checkFlavor(filter, recipe)){continue;}

        	// If diets don't match, break
        	if(!checkDiets(filter, recipe)){continue;}
        	// Else add the recipe
        	filteredRecipes.add(recipe);
    	}
        return filteredRecipes;
    }
	
    private boolean checkIngredients(Filter f, Recipe r) {
    	Set<String> ingredients_set = r.getIngredients().keySet();
    	List<String> recipe_ingredients = new ArrayList<String>(ingredients_set);
    	return isS2SubsetOfS1(f.getIngredients(), recipe_ingredients);
	}
    
	private boolean checkAppliances(Filter f, Recipe r)
	{
		return isS2SubsetOfS1(f.getAppliances(), r.getAppliances());
	}
	
	private boolean checkDifficultyRating(Filter f, Recipe r)
	{
		return r.getDifficultyRating() <= f.getDifficultyRating();
	}
	
	private boolean checkQualityRating(Filter f, Recipe r)
	{
		return r.getQualityRating() >= f.getQualityRating();
	}
	
	private boolean checkCuisine(Filter f, Recipe r)
	{
		return f.getCuisine().equals(r.getCuisine());
	}
	
	private boolean checkFlavor(Filter f, Recipe r)
	{
		return f.getFlavor().equals(r.getFlavor());
	}
	
	private boolean checkDiets(Filter f, Recipe r)
	{
		return isS2SubsetOfS1(r.getDiets(), f.getDiets());
	}
	
	private static boolean isS2SubsetOfS1(List<String> S1, List<String> S2) 
	{
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
	
} // end of CustomRecipeRepositoryImpl class
