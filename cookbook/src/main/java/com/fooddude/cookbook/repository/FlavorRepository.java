package com.fooddude.cookbook.repository;

import com.fooddude.cookbook.model.Flavor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlavorRepository extends JpaRepository<Flavor, Integer> {
}
