package by.mk_jd2_92_22.foodCounter.services.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class FoodDiaryDTO {

    private LocalDateTime dtSupply;
    private Product product;
    private Dish dish;
    private int weight;

    public FoodDiaryDTO() {
    }

    public FoodDiaryDTO(LocalDateTime dtSupply, Product product, Dish dish, int weight) {
        this.dtSupply = dtSupply;
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

    public LocalDateTime getDtSupply() {
        return dtSupply;
    }

    public void setDtSupply(LocalDateTime dtSupply) {
        this.dtSupply = dtSupply;
    }

    public class Product{
        private UUID uuid;

        public UUID getUuid() {
            return uuid;
        }

        public void setUuid(UUID uuid) {
            this.uuid = uuid;
        }
    }

    public class Dish{
        private UUID uuid;

        public UUID getUuid() {
            return uuid;
        }

        public void setUuid(UUID uuid) {
            this.uuid = uuid;
        }
    }
}
