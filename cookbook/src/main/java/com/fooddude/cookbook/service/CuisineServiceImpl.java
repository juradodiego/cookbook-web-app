package com.fooddude.cookbook.service;

import com.fooddude.cookbook.model.Cuisine;
import com.fooddude.cookbook.repository.CuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuisineServiceImpl implements CuisineService{
    @Autowired
    private CuisineRepository cuisineRepository;

    @Override
    public Cuisine saveCuisine(Cuisine cuisine) {
        return cuisineRepository.save(cuisine);
    }

    @Override
    public List<Cuisine> getAllCuisines() {
        return cuisineRepository.findAll();
    }
}
