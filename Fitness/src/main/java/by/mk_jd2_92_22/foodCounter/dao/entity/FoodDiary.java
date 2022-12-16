package by.mk_jd2_92_22.foodCounter.dao.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class FoodDiary {

    private UUID uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;

    private  Product product;
    private Dish dish;
    private int weight;

    public FoodDiary() {
    }

    public FoodDiary(UUID uuid, LocalDateTime dtCreate, LocalDateTime dtUpdate,
                     Product product, Dish dish, int weight) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.product = product;
        this.dish = dish;
        this.weight = weight;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }


    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
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

    @Override
    public String toString() {
        return "FoodDiary{" +
                "uuid=" + uuid +
                ", dtCreate=" + dtCreate +
                ", dtUpdate=" + dtUpdate +
                ", product=" + product +
                ", dish=" + dish +
                ", weight=" + weight +
                '}';
    }
}
