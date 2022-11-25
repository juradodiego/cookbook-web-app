package com.fooddude.cookbook.controller;

import com.fooddude.cookbook.model.Filter;
import com.fooddude.cookbook.model.Recipe;
import com.fooddude.cookbook.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// Posts / Gets from URL = "localhost:8080/recipe/..."

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @PostMapping("/add")
    public String add(@RequestBody Recipe recipe){
        recipeService.saveRecipe(recipe);
        return "New recipe is added";
    }

    @GetMapping("/getAll")
    public List<Recipe> getAllRecipes(){
        return recipeService.getAllRecipes();
    }

    @GetMapping("/getFiltered")
    public List<Recipe> getFilteredRecipes(Filter filter){
        return recipeService.getFilteredRecipes(filter);
    }

    // TODO fix delete method -> delete does not delete
    @PostMapping("/delete")
    public String delete(@RequestBody Recipe recipe){
        recipeService.deleteRecipe(recipe);
        return "A recipe has been deleted";
    }
}
