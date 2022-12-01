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

		String filterCuisine = filter.getCuisine();
		String filterFlavor = filter.getFlavor();
		double filterDiffRating = filter.getDifficultyRating();
		double filterQualRating = filter.getQualityRating();
		List<String> filterAppliances = filter.getAppliances();
		List<String> filterDiets = filter.getDiets();
		List<String> filterIngredients = filter.getIngredients();

		for (Recipe recipe : allRecipes){

			if (filterCuisine != null && !filterCuisine.equals(recipe.getCuisine())) continue;
			if (filterFlavor != null && !filterFlavor.equals(recipe.getFlavor())) continue;
			if (filterDiffRating != 0 && !(filterDiffRating == recipe.getDifficultyRating())) continue;
			if (filterQualRating != 0 && !(filterQualRating == recipe.getQualityRating())) continue;
			if (filterAppliances != null && !filterAppliances.containsAll(recipe.getAppliances())) continue;
			if (filterDiets != null && !recipe.getDiets().containsAll(filterDiets)) continue;

			List<String> ingredients = new ArrayList<String>();
			ingredients.addAll(recipe.getIngredients().keySet());
			if (filterIngredients != null && !ingredients.containsAll(filterIngredients)) continue;

			filteredRecipes.add(recipe);

		}

        return filteredRecipes;
    }
	
} // end of CustomRecipeRepositoryImpl class
