class RecipeDAO
{

    public Recipe getRecipe(int recipe_id)
    {

        try {

            Recipe r = null;

            // Connect to database here
            // Get recipe from database
            // Store recipe -> r

            return r;

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            return null;
        }
        
    }

}

class Recipe
{

    // Instance Variables for Recipe Object 
    String name;
    String description;
    String[] instructions;
    String[] ingredients;
    String[] appliances;
    Double cookTime;
    Float difficultyRating;
    Float qualityRating;
    String cuisine;
    String flavor;
    String[] dietaryRestrictions;

    // Constructor for Recipe Object
    public Recipe(String name, String description, String[] instructions, String[] ingredients, String[] appliances, Double cookTime, Float difficultyRating, Float qualityRating, String cuisine, String flavor, String[] dietaryRestrictions){

        this.name = name;
        this.description = description;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.appliances = appliances;
        this.cookTime = cookTime;
        this.difficultyRating = difficultyRating;
        this.qualityRating = qualityRating;
        this.cuisine = cuisine;
        this.flavor = flavor;

    }

    //Getters and Setters as dictated by the SRS
    public float getQualityRating(){
        return this.qualityRating;
    }

    public float getDifficultyRating(){
        return this.difficultyRating;
    }

    public void setQualityRating(Float newQualityRating){
        this.qualityRating = newQualityRating;
    }

    public void setDifficultyRating(Float newDifficultyRating){
        this.difficultyRating = newDifficultyRating;
    }
}