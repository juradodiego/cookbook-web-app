package com.fooddude.cookbook.repository;

import com.fooddude.cookbook.model.Filter;
import com.fooddude.cookbook.model.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomRecipeRepositoryImpl implements CustomRecipeRepository {
	@Override
	public Recipe findRecipeById(Integer id, List<Recipe> allRecipes) {
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
			if (ids.contains(recipe.getId()))
				recipes.add(recipe);
		return recipes;
	}

	@Override
	public List<Recipe> filteredSearch(Filter filter, List<Recipe> allRecipes) {
		List<Recipe> filteredRecipes = new ArrayList<>();

		String filterCuisine = filter.getCuisine() != null ? filter.getCuisine().toLowerCase() : filter.getCuisine();
		String filterFlavor = filter.getFlavor() != null ? filter.getFlavor().toLowerCase() : filter.getFlavor();

		double filterDiffRating = filter.getDifficultyRating();
		double filterQualRating = filter.getQualityRating();

		List<String> filterAppliances = filter.getAppliances() != null ? filter.getAppliances().stream().map(String ::toLowerCase).collect(Collectors.toList()) : filter.getAppliances();
		List<String> filterDiets = filter.getDiets() != null ? filter.getDiets().stream().map(String ::toLowerCase).collect(Collectors.toList()) : filter.getDiets();
		List<String> filterIngredients = filter.getIngredients() != null ? filter.getIngredients().stream().map(String ::toLowerCase).collect(Collectors.toList()) : filter.getIngredients();

		for (Recipe recipe : allRecipes) {

			if (filterCuisine != null && !filterCuisine.equals(recipe.getCuisine().toLowerCase()))
				continue;
			if (filterFlavor != null && !filterFlavor.equals(recipe.getFlavor().toLowerCase()))
				continue;
			if (filterDiffRating != 0 && !(filterDiffRating >= recipe.getDifficultyRating()))
				continue;
			if (filterQualRating != 0 && !(filterQualRating <= recipe.getQualityRating()))
				continue;
			if (filterAppliances != null && !filterAppliances.containsAll(recipe.getAppliances().stream().map(String ::toLowerCase).collect(Collectors.toList())))
				continue;
			if (filterDiets != null && !recipe.getDiets().stream().map(String ::toLowerCase).collect(Collectors.toList()).containsAll(filterDiets))
				continue;

			if (filterIngredients != null) {
				List<String> ingredients = new ArrayList<String>();
				if (recipe.getIngredients() != null) {
					ingredients.addAll(recipe.getIngredients().keySet().stream().map(String ::toLowerCase).collect(Collectors.toList()));
					if (!ingredients.containsAll(filterIngredients))
						continue;
				} else {
					continue;
				}
			}

			filteredRecipes.add(recipe);

		}

		return filteredRecipes;
	}

} // end of CustomRecipeRepositoryImpl class
