package by.mk_jd2_92_22.foodCounter.services.dto;


import java.util.List;


public class RecipeDTO {

    private String title;
    private List<IngredientDTO> ingredients;

    public RecipeDTO() {
    }

    public RecipeDTO(String name, List<IngredientDTO> ingredients) {
        this.title = name;
        this.ingredients = ingredients;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<IngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }

}
