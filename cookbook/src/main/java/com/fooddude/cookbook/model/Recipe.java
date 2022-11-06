package com.fooddude.cookbook.model;

import javax.persistence.*;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String[] instructions;
    private String[] appliances;
    private float cookTime;
    private float difficultyRating;
    private float qualityRating;
    @ManyToOne
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;
    @ManyToOne
    @JoinColumn(name = "flavor_id")
    private Flavor flavor;
    private String[] diets;

    public Recipe() {
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

    public Flavor getFlavor() {
        return flavor;
    }

    public void setFlavor(Flavor flavor) {
        this.flavor = flavor;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public String[] getDiets() {
        return diets;
    }

    public void setDiets(String[] diets) {
        this.diets = diets;
    }
}
