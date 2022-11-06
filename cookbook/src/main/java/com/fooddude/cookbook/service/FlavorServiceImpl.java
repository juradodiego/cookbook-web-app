package com.fooddude.cookbook.service;

import com.fooddude.cookbook.model.Flavor;
import com.fooddude.cookbook.repository.FlavorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlavorServiceImpl implements FlavorService{

    @Autowired
    private FlavorRepository flavorRepository;

    @Override
    public Flavor saveFlavor(Flavor flavor) {
        return flavorRepository.save(flavor);
    }

    @Override
    public List<Flavor> getAllFlavors() {
        return flavorRepository.findAll();
    }
}
