package by.example.demo.pizzeria.dao.entity;

import by.example.demo.pizzeria.dao.entity.api.IStage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity
public class Stage implements IStage {

    @Id
    private long id;
//    @Column(name = "dt_create")
//    private LocalDateTime dtCreate;
//
//    @Version
//    @Column(name = "dt_update")
//    private LocalDateTime dtUpdate;

    private String description;
    private LocalTime time;

    @Column(name = "order_status")
    private long orderStatus;

    public Stage() {
    }

    public Stage(String description, LocalTime time, long orderStatus) {
        this.description = description;
        this.time = time;
        this.orderStatus = orderStatus;
    }

    public Stage(long id, String description, LocalTime time, long orderStatus) {
        this.id = id;
        this.description = description;
        this.time = time;
        this.orderStatus = orderStatus;
    }



    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public LocalTime getTime() {
        return time;
    }

    @Override
    public long getOrderStatus() {
        return orderStatus;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", time=" + time +
                '}';
    }
}

