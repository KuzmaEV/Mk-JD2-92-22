package by.mk_jd2_92_22.foodCounter.services.dto;


import java.util.UUID;

public class IngredientDTO {

    private UUID product;
    private int weight;

    public IngredientDTO() {
    }

    public IngredientDTO(UUID product, int weight) {
        this.product = product;
        this.weight = weight;
    }


    public UUID getProduct() {
        return product;
    }

    public void setProduct(UUID product) {
        this.product = product;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
