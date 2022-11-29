package com.fooddude.cookbook.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Filter {
    private List<String> ingredients;
    private List<String> appliances;
    private double difficultyRating;
    private double qualityRating;
    private String cuisine;
    private String flavor;
    private List<String> diets;

} // end of Filter class
