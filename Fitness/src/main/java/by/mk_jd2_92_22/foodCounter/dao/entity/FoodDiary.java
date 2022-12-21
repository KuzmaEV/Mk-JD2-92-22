package by.mk_jd2_92_22.foodCounter.dao.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "food_diary")
public class FoodDiary {

    @Id
    private UUID uuid;

//    @JsonSerialize()
//    @JsonDeserialize
    @Column(name = "dt_create")
    private LocalDateTime dtCreate;

    @Version
    @Column(name = "dt_update")
    private LocalDateTime dtUpdate;

    @Column(name = "dt_supply")
    private LocalDateTime dtSupply;

    @ManyToOne
    private  Product product;
    @ManyToOne
    private Dish dish;

    private int weight;

    public FoodDiary() {
    }

    public FoodDiary(UUID uuid, LocalDateTime dtCreate, LocalDateTime dtUpdate, LocalDateTime dtSupply,
                     Product product, Dish dish, int weight) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.dtSupply = dtSupply;
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

    public LocalDateTime getDtSupply() {
        return dtSupply;
    }

    public void setDtSupply(LocalDateTime dtSupply) {
        this.dtSupply = dtSupply;
    }

    @Override
    public String toString() {
        return "FoodDiary{" +
                "uuid=" + uuid +
                ", dtCreate=" + dtCreate +
                ", dtUpdate=" + dtUpdate +
                ", dtSupply=" + dtSupply +
                ", product=" + product +
                ", dish=" + dish +
                ", weight=" + weight +
                '}';
    }
}
