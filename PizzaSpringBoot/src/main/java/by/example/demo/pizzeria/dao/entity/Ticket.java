package by.example.demo.pizzeria.dao.entity;


import by.example.demo.pizzeria.dao.entity.api.ITicket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
public class Ticket implements ITicket {

    @Id
    private long id;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @OneToOne
    private Order order;

    public Ticket() {
    }

    public Ticket(LocalDateTime createAt, Order order) {
        this.createAt = createAt;
        this.order = order;
    }

    public Ticket(long number, LocalDateTime createAt, Order order) {
        this.id = number;
        this.createAt = createAt;
        this.order = order;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public LocalDateTime getCreateAt() {
        return createAt;
    }

    @Override
    public Order getOrder() {
        return order;
    }


    @Override
    public void setOrder(Order order) {
        this.order = order;
    }
}
