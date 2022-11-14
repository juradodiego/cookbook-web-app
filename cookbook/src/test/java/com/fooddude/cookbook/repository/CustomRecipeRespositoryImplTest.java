package com.fooddude.cookbook.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import com.fooddude.cookbook.model.Filter;
import com.fooddude.cookbook.model.Recipe;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class CustomRecipeRespositoryImplTest  extends CustomRecipeRepositoryImpl {

	

	String[] instructions = new String[] {"Step 1", "Step 3", "Step 3"};
	//In the hash map, ingredient name is key, amount is value.
	HashMap<String, String> ingredients = new HashMap<String, String>();
	
	String[] appliances = new String[] {"Frying pan", "Stove top"};
	String[] diets = new String[] {"Healthy"};
	
	
	
	Recipe recipe = new Recipe("eggs", "nice eggs!", instructions, ingredients, appliances, (float)5.0,(float) 5.0, (float)5.0, "French", "Savory", diets);
	
	Filter filter = new Filter("French", "Savory");
	
	String[] filterIngredient = new String[] {"egg"	};
	
	List<Recipe> allRecipes = new ArrayList<Recipe>();

	

	
	
	@BeforeEach
	void setUp() throws Exception {
		filter.setIngredients(filterIngredient);
		filter.setAppliances(appliances);
		filter.setDifficultyRating((float) 5.0);
		filter.setQualityRating((float) 5.0);
		filter.setCuisine("French");
		filter.setFlavor("Savory");
		filter.setDiets(diets);
		
		ingredients.put("egg", "1");

		

	}
	

	@AfterEach
	void tearDown() throws Exception {
	}
	/**
	 * Testing that the correct filtered Recipes are added.
	 * Observed initially is empty, but should get one recipe
	 *  added into it after the call to filteredSearch
	 */
	@Test
	void testFilteredSearch() {
		
		
		List<Recipe> observed = new ArrayList<Recipe>();
		
		allRecipes.add(recipe);
			
		
		observed = filteredSearch(filter, allRecipes);
		
		
		int expected = 1;
		
		String msg = "Adding one recipe to filteredRecipes";
		
		assertEquals(msg, expected, observed.size() );
	}


	


	
	
	
		
		
				
		
		
	
	

}
