package com.fooddude.cookbook.controller;

import com.fooddude.cookbook.exception.InvalidRecipeIdException;
import com.fooddude.cookbook.model.Filter;
import com.fooddude.cookbook.model.Recipe;
import com.fooddude.cookbook.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Posts / Gets from URL = "localhost:8080/recipe/..."
@RestController
@RequestMapping("/recipe")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/get")
    public Recipe getRecipe(@RequestParam Integer id) throws InvalidRecipeIdException {
        return recipeService.getRecipe(id);
    }

    @GetMapping("/getAll")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PostMapping("/getFiltered")
    public List<Recipe> getFilteredRecipes(@RequestBody Filter filter) {
        return recipeService.getFilteredRecipes(filter);
    }

    @PostMapping("/getByIds")
    public List<Recipe> getRecipesByIds(@RequestBody List<Integer> ids) {
        return recipeService.getRecipesByIds(ids);
    }

    @PostMapping("/add")
    public String addRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
        return "New recipe is added";
    }

    @PostMapping("/delete")
    public String deleteRecipe(@RequestBody Integer id) throws InvalidRecipeIdException {
        recipeService.deleteRecipe(id);
        return "A recipe has been deleted";
    }

} // end of RecipeController class
