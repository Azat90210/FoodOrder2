package com.example.shaurma.repositories;

import com.example.shaurma.models.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
