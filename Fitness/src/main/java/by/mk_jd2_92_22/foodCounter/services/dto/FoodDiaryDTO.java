package by.mk_jd2_92_22.foodCounter.services.dto;

import by.mk_jd2_92_22.foodCounter.dao.entity.Dish;
import by.mk_jd2_92_22.foodCounter.dao.entity.Product;

public class FoodDiaryDTO {

    private Product product;
    private Dish dish;
    private int weight;

    public FoodDiaryDTO() {
    }

    public FoodDiaryDTO(Product product, Dish dish, int weight) {
        this.product = product;
        this.dish = dish;
        this.weight = weight;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
