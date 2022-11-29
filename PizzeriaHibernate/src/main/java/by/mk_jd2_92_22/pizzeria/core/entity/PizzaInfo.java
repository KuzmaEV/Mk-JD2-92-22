package by.mk_jd2_92_22.pizzeria.core.entity;



import by.mk_jd2_92_22.pizzeria.core.entity.api.IPizzaInfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "pizza_info")
public class PizzaInfo implements IPizzaInfo {

    @Id
    @GeneratedValue
    private final long id;

    @Column(name = "dt_create")
    private final LocalDateTime dtCreate;

    @Column(name = "dt_update")
    private final LocalDateTime dtUpdate;
    private final String name;
    private final String description;
    private final int size;



    public PizzaInfo(long id, LocalDateTime dtCreate, LocalDateTime dtUpdate, String name, String description, int size) {
        this.id = id;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.name = name;
        this.description = description;
        this.size = size;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    @Override
    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "PizzaInfo{" +
                "id=" + id +
                ", dtCreate=" + dtCreate +
                ", dtUpdate=" + dtUpdate +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", size=" + size +
                '}';
    }
}
