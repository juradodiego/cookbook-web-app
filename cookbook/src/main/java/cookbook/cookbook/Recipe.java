package cookbook.cookbook;

public class Recipe implements Recipe_Inter{
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

    public void setQualityRating(float newQualityRating){
        this.qualityRating = newQualityRating;
    }

    public void setDifficultyRating(float newDifficultyRating){
        this.difficultyRating = newDifficultyRating;
    }
}

