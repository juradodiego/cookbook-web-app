package com.fooddude.cookbook.model;

public class Filter {
    private String[] ingredients;
    private String[] appliances;
    private float difficultyRating;
    private float qualityRating;
    private String cuisine;
    private String flavor;
    private String[] diets;

    public Filter(String cuisine, String flavor) {
        this.cuisine = cuisine;
        this.flavor = flavor;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String[] getAppliances() {
        return appliances;
    }

    public void setAppliances(String[] appliances) {
        this.appliances = appliances;
    }

    public float getDifficultyRating() {
        return difficultyRating;
    }

    public void setDifficultyRating(float difficultyRating) {
        this.difficultyRating = difficultyRating;
    }

    public float getQualityRating() {
        return qualityRating;
    }

    public void setQualityRating(float qualityRating) {
        this.qualityRating = qualityRating;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String[] getDiets() {
        return diets;
    }

    public void setDiets(String[] diets) {
        this.diets = diets;
    }

} // end of Filter class
