package com.fooddude.cookbook.service;

import com.fooddude.cookbook.model.Cuisine;

import java.util.List;

public interface CuisineService {
    public Cuisine saveCuisine(Cuisine cuisine);
    public List<Cuisine> getAllCuisines();
}
