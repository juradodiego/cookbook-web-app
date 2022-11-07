package tests;

import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.Assert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class CustomRecipeRepositoryImplTest extends TestCase {

	@BeforeEach
	protected void setUp() throws Exception {
		
		String[] instructions = new String[] {"Step 1", "Step 3", "Step 3"};
		//In the hash map, ingredient name is key, amount is value.
		HashMap<String, String> ingredients = new HashMap<>();
		map.put("eggs", "two eggs");
		map.put("salt", "a pinch");
		
		String[] appliances = new String[] {"Frying pan", "Stove top"};
		String[] diets = new String[] {"Healthy"};
		
		
		
		Recipe recipe = new Recipe(2, "eggs", "nice eggs!", instructions, ingredients, appliances, 4.01, 5.0, 5.0, "French", "Savory", diets);
		
		
		String[] filterIngredients = new String[] {"eggs", "salt"};
		String[] filterAppliances = new String[] {"Frying pan", "Stove top"};
		String[] filterDiets = new String[] {"Healthy"};
		
		Filter filter = new Filter(filterIngredients, filterAppliances, 5.0, 5.0, "French", "Savory", filterDiets);
		
	}

	@AfterEach
	protected void tearDown() throws Exception {
		recipe = null;
		filter = null;
	}
	/**
	 * Check to make sure that if recipe and filtered recipe are the same it does actually get added.
	 * Preconditions: Each element of filter and recipe are the same.
	 * Expected outp: Since all are the same we should be calling Add. I don't want to check the add method here
	 * I can use mocks to just check if the call to that function was made, which would verify that this function works properly.
	 * Dr. Sarwar is doing a TDD workshop Thursday, wait until then so I can remeber how to get mocks all set up. 
	 */
	@Test
	void testFilteredSearch() {
		fail("Not yet implemented");
		//IF everything is the same, make sure it returns "new recipe is added"
	}
	/**
	 * Making sure that, given two equal ingredient sets, it return true.
	 * Prerequesites: Recipe and filter have identical ingredients lists. 
	 */
	@Test
	void testCheckIngredientsEqual() {
		assertTrue("Checking that ingredients are equal when they are equal", checkIngredients(filter, recipe));
	}
	/**
	 * Similar to the previous test, but this time the ingredient sets are totally different.
	 * Prerequesites: Filter and recipe share no ingredients.
	 * 
	 */
	@Test
	void testCheckIngredientsNotEqual() {
		
		String[] newIngredients = new String[] {"Giraffe"};
		filter.setIngredients(newIngredients);
		
		assertFalse("Checking ingredients when they are not equal.", checkIngredients(filter, recipe));
	}
	
	/**
	 *Testing checkAppliance
	 *Prerequesites: Filter and Recipe have the same appliance list
	 */
	
	@Test
	void testCheckApplianceEqual() {
		assertTrue("Checking that appliances are equal when they are equal.", checkAppliance(filter, recipe));
	}
	
	/**
	 * testing checkAppliance when filter and recipe have totally different appliances
	 * Prerequesites: Filter and recipe have completely different appliance lists.
	 */
	@Test
	void testCheckApplianceNotEqual() {
		String[] newAppliances = new String[] {"blast furnace", "Giant electric mixing bowl"}
		filter.setAppliances(newAppliances);
		
		assertFalse("Checking appliances when they are not equal", checkAppliance(filter, recipe));
	}
	/**
	 * Testing checkDifficultyRating when the difficulty ratings are the same.
	 * Prerequesites: Filter and recipe have the same difficulty rating.
	 */
	@Test
	void testCheckDifficultyRatingEqual() {
		assertTrue("Both difficulties are identical", checkDifficultyRating(filter, recipe));
		
	}
	
	/**
	 * Testing check difficulty rating when recipe difficulty is less than
	 * filter difficuly
	 * Prerequesites: Recipe has a lower difficulty rating than filter.
	 */
	@Test
	void testCheckDifficultyRatingRecipeLesser() {
		recipe.setDifficultyRating(1.0);
		assertTrue("Recipe is less than filter difficulty", checkDifficultyRating(filter, recipe));
	}
	
	/**
	 * Testing check difficulty rating when recipe difficulty is greater than
	 * filer difficulty.
	 * Prerequesites: recipe has a higher difficulty rating than filter.
	 */
	@Test
	void testCheckDifficultyRatingRecipeGreater() {
		recipe.setDifficultyRating(9.0);
		assertTrue("Recipe is greater than filter difficulty", checkDifficultyRating(filter, recipe));
	}
	
	/**
	 * Testing checkQualityRating when both are identical
	 * Prerequesites: Recipe and filter have the same quality rating.
	 */
	@Test
	void testCheckQualityRatingEqual() {
		assertTrue("Both have the same quality rating", checkQualityRating(filter, recipe));
	}
	
	/**
	 * Testing checkQualityRating when recipe is greater
	 * Prerequesites: Recipe has a higher quality rating than 
	 * filter
	 */
	@Test
	void testCheckQualityRatingRecipeGreater() {
		recipe.setQualityRating(9.0);
		assertTrue("Recipe has a higher rating than filter", checkQualityRating(filter, recipe));
	}
	
	/**
	 * Testing checkQualityRating when Recipe is less
	 * Prerequesites: Recipes has a lower quality rating than filter
	 */
	@Test
	void testCheckQualityRatingRecipeLesser() {
		recipe.setQualityRating(1.0);
		assertFalse("Recipe has a lower rating than filter", checkQualityRating(filter, recipe));
	}
	/**
	 * Testing checkCuisine when the cuisines are exactly the same
	 * Prerequesites: Recipe and filter have the same cuisine.
	 */
	@Test
	void testCheckCuisineEqual() {
		assertTrue("The cuisine of filter and recipe are the same", checkCuisine(filter, recipe));
	}
	
	/**
	 * Testing check cuising when the cuisines are not the same
	 * Prerequisites: Recipe and filter do NOT have the same cuisine
	 */
	@Test
	void testCheckCuisineNotEqual() {
		
		String newCuisine = "Cave man food";
		assertFalse("The cuisine of recipe and filter differ", checkCuisine(filter, recipe));
	}
	/**
	 * Testing checkDiets when the diets are the same
	 * Prerequisites: Recipe and filter have the same diet types.
	 */
	@Test
	void testCheckDietsEqual(){
		assertTrue("The diet of recipe and filter are the same", checkDiets(filter, recipe));
	}
	
	/**
	 * Testing checkDiets when the diets are different
	 * Prerequisites: Recipe and filter have different diet types
	 */
	@Test
	void testCheckDietsNotEqual() {
		String[] newDiet = new String[] {"junk"};
		filter.setDiet(newDiet);
		assertFalse("The diet of recipe and filter are NOT the same", checkDiets(filter, recipe));
	}
	/**
	 * Testing checkFlavors when the flavors are the same.
	 * Prerequisites: Filter and recipe have the same flavor
	 */
	@Test
	void  testCheckFlavorEqual() {
		assertTrue("The flavor of filter and recipe are the same", checkFlavor(filter, recipe));
	}
	
	/**
	 * Testing checkFlavors when the flavors are NOT the same
	 * Prerequisites: Filter and recipe do not have the same flavor
	 */
	
	@Test
	void testCheckFlavorNotEqual() {
		filter.setFlavor("Sweet");
		assertFalse("The flavor of filter and recipe are NOT the same ", checkFlavor(filter, recipe));
		
	}
	/**
	 * Testing if it is subset when they are the same.
	 * Prerequisites: The two String arrays that are being compared are the same.
	 */
	@Test
	void testisS2SubsetofS1Identical() {
		
		assertTrue("Testing subset of two identical arrays", S2SubsetOfS1(appliance, filterAppliances));
		
	}
	/**
	 * Testing S2SubsetofS1Identical when it is not a subset
	 * Prerequesits: Two arrays, no shared elements between them.
	 */
	@Test
	void testArraysNotSubsets() {
		String[] forTest = new String[] {"Giraffe"};
		String[] alsoForTest = newString[] {"Alligator"};
		
		assertFalse("Testing subset of two totally different arrays", S2SubsetOfS1(fortTest, alsoForTest));
	}
	
	/**
	 * Testing S2SubsetofSiIdentical when one of the arrays is totally empty.
	 * Prerequesites: Filter array is totally empty
	 * It should still return true. Empty set is subset of every set. 
	 */
	@Test
	void testArraysOneEmpty() {
		String[] empty = new String[] {""};
		String[] notEmpty = new String[] {"johnny"};
		assertTrue("Testing subset when one is totally empty",S2SubsetOfS1(empty, notEmpty) );
	}
	
	
	
	
	
	
	
	

}
