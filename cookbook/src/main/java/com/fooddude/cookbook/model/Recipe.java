package com.fooddude.cookbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String[] instructions;
    private HashMap<String, String> ingredients;
    private String[] appliances;
    private float cookTime;
    private float difficultyRating;
    private float qualityRating;
    private String cuisine;
    private String flavor;
    private String[] diets;

    public Recipe() {
    }

    public Recipe(String name, String description, String[] instructions, HashMap<String, String> ingredients, String[] appliances, float cookTime, float difficultyRating, float qualityRating, String cuisine, String flavor, String[] diets) {
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
        this.diets = diets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getInstructions() {
        return instructions;
    }

    public void setInstructions(String[] instructions) {
        this.instructions = instructions;
    }

    public HashMap<String, String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(HashMap<String, String> ingredients) {
        this.ingredients = ingredients;
    }

    public String[] getAppliances() {
        return appliances;
    }

    public void setAppliances(String[] appliances) {
        this.appliances = appliances;
    }

    public float getCookTime() {
        return cookTime;
    }

    public void setCookTime(float cookTime) {
        this.cookTime = cookTime;
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
}
