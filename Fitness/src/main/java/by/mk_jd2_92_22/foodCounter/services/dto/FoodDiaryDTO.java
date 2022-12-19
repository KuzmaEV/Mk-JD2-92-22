package by.mk_jd2_92_22.foodCounter.services.dto;

import java.util.UUID;

public class FoodDiaryDTO {

    private UUID product;
    private UUID dish;
    private int weight;

    public FoodDiaryDTO() {
    }

    public FoodDiaryDTO(UUID product, UUID dish, int weight) {
        this.product = product;
        this.dish = dish;
        this.weight = weight;
    }

    public UUID getProduct() {
        return product;
    }

    public void setProduct(UUID product) {
        this.product = product;
    }

    public UUID getDish() {
        return dish;
    }

    public void setDish(UUID dish) {
        this.dish = dish;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
