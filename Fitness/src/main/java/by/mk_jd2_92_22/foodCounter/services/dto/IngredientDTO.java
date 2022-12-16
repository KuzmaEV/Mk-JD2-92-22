package by.mk_jd2_92_22.foodCounter.services.dto;

import by.mk_jd2_92_22.foodCounter.dao.entity.Product;

public class IngredientDTO {

    private Product product;
    private int weight;

    public IngredientDTO() {
    }

    public IngredientDTO(Product product, int weight) {
        this.product = product;
        this.weight = weight;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
