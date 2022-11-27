package com.fooddude.cookbook.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;

@Entity
@Data
@Table(name="tbl_recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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

} // end of Recipe class
