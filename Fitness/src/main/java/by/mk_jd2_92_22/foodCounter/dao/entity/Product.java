package by.mk_jd2_92_22.foodCounter.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Product {

    @Id
    private UUID uuid;

    @Column(name = "dt_create")
    private LocalDateTime dtCreate;

    @Version
    @Column(name = "dt_update")
    private LocalDateTime dtUpdate;

    private String name;

    private int kcal;
    private int proteins;
    private int fats;
    private int carbohydrates;

    private int weight;

    public Product() {
    }

    public Product(UUID uuid, LocalDateTime dtCreate, LocalDateTime dtUpdate,
                   String name, int kcal, int proteins, int fats, int carbohydrates, int weight) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.name = name;
        this.kcal = kcal;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "uuid=" + uuid +
                ", dtCreate=" + dtCreate +
                ", dtUpdate=" + dtUpdate +
                ", name='" + name + '\'' +
                ", kcal=" + kcal +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                ", weight=" + weight +
                '}';
    }
}
