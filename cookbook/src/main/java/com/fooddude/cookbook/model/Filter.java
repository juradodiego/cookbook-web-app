package com.fooddude.cookbook.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Filter {
    private String[] ingredients;
    private String[] appliances;
    private float difficultyRating;
    private float qualityRating;
    private String cuisine;
    private String flavor;
    private String[] diets;

} // end of Filter class
