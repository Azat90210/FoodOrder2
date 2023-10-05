package com.example.shaurma.controllers;


import com.example.shaurma.models.Ingredient;
import com.example.shaurma.models.Shaurma;
import com.example.shaurma.models.ShaurmaOrder;
import com.example.shaurma.repositories.IngredientRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("shaurmaOrder")
public class DesignShaurmaController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignShaurmaController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepo.findAll();
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType((List<Ingredient>) ingredients, type));
        }
    }

    @ModelAttribute(name = "shaurmaOrder")
    public ShaurmaOrder order() {
        return new ShaurmaOrder();
    }

    @ModelAttribute(name = "shaurma")
    public Shaurma shaurma() {
        return new Shaurma();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processShaurma(@Valid Shaurma shaurma, Errors errors,
                                 @ModelAttribute ShaurmaOrder shaurmaOrder) {
        if (errors.hasErrors()) {
            return "design";
        }

        shaurmaOrder.addShaurma(shaurma);
        log.info("Processing shaurma: {}", shaurma);
        return "redirect:/orders/current";
    }


    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}

