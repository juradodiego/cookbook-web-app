package com.fooddude.cookbook.model;

import lombok.Data;

@Data
public class Filter {
    private String[] ingredients;
    private String[] appliances;
    private float difficultyRating;
    private float qualityRating;
    private String cuisine;
    private String flavor;
    private String[] diets;

} // end of Filter class
