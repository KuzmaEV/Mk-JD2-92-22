package by.example.demo.pizzeria.dao.entity;


import by.example.demo.pizzeria.dao.entity.api.ITicket;

import java.time.LocalDateTime;

public class Ticket implements ITicket {

    private String number;
    private LocalDateTime createAt;
    private Order order;

    public Ticket() {
    }

    public Ticket(String number, LocalDateTime createAt, Order order) {
        this.number = number;
        this.createAt = createAt;
        this.order = order;
    }

    @Override
    public String getNumber() {
        return this.number;
    }

    @Override
    public LocalDateTime getCreateAt() {
        return createAt;
    }

    @Override
    public Order getOrder() {
        return order;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
