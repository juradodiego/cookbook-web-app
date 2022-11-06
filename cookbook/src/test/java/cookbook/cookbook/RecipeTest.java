import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RecipeTest {

	 Recipe recipe = new Recipe(null, null, null, null, null, null, (float) 5.0, (float)4.0, null, null, null);

	 

	@Test
	void testGetQualityRating() {
		
		assertEquals(4.0, recipe.getQualityRating());
		
	}

	@Test
	void testGetDifficultyRating() {
		
		assertEquals(5.0, recipe.getDifficultyRating());
		
	}

	@Test
	void testSetQualityRating() {
		recipe.setQualityRating((float)3.0);
		
		assertEquals(3.0, recipe.getQualityRating());
	}

	@Test
	void testSetDifficultyRating() {
		recipe.setDifficultyRating((float) 2.0);
		
		assertEquals(2.0, recipe.getDifficultyRating());
		
	}

}