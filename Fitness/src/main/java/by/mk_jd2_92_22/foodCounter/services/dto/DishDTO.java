package by.mk_jd2_92_22.foodCounter.services.dto;

import by.mk_jd2_92_22.foodCounter.dao.entity.Ingredient;

import java.util.List;

public class DishDTO {

    private String name;
    private List<Ingredient> ingredients;

    public DishDTO() {
    }

    public DishDTO(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
