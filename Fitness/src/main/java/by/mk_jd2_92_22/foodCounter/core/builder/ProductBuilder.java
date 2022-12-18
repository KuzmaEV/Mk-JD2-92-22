package by.mk_jd2_92_22.foodCounter.core.builder;

import by.mk_jd2_92_22.foodCounter.dao.entity.Product;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProductBuilder {

    private UUID uuid;

    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;

    private String name;

    private int kcal;
    private int proteins;
    private int fats;
    private int carbohydrates;

    private int weight;

    private ProductBuilder() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public ProductBuilder setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public ProductBuilder setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
        return this;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public ProductBuilder setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public int getKcal() {
        return kcal;
    }

    public ProductBuilder setKcal(int kcal) {
        this.kcal = kcal;
        return this;
    }

    public int getProteins() {
        return proteins;
    }

    public ProductBuilder setProteins(int proteins) {
        this.proteins = proteins;
        return this;
    }

    public int getFats() {
        return fats;
    }

    public ProductBuilder setFats(int fats) {
        this.fats = fats;
        return this;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public ProductBuilder setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public ProductBuilder setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public static ProductBuilder create(){
        return new ProductBuilder();
    }
    public Product build(){
        return new Product(uuid, dtCreate, dtUpdate, name, kcal, proteins, fats, carbohydrates, weight);
    }


}
