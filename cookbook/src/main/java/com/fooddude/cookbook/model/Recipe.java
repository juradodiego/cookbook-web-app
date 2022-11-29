package com.fooddude.cookbook.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String name;
    private String description;
    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> instructions;
    private HashMap<String, String> ingredients;
    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> appliances;
    private double cookTime;
    private double difficultyRating;
    private double qualityRating;
    private String cuisine;
    private String flavor;
    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> diets;

} // end of Recipe class
