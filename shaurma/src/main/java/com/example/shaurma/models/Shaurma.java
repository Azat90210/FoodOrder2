package com.example.shaurma.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class Shaurma {
    @NotNull
    @Size(min = 1, message = "Название дол;но содержать как минимум 3 символа")
    private String name;

    @NotNull
    @Size(min = 1, message = "Выберите хотябы один ингредиент")
    private List<Ingredient> ingredients;
}
