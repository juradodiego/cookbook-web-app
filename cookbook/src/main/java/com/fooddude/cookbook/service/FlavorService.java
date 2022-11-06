package com.fooddude.cookbook.service;

import com.fooddude.cookbook.model.Flavor;

import java.util.List;

public interface FlavorService {
    public Flavor saveFlavor(Flavor flavor);
    public List<Flavor> getAllFlavors();
}
