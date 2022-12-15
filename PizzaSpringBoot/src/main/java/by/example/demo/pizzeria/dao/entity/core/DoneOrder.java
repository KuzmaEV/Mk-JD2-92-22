package by.example.demo.pizzeria.dao.entity.core;


import by.example.demo.pizzeria.dao.entity.api.ITicket;
import by.example.demo.pizzeria.dao.entity.api.x.IDoneOrder;

import java.util.List;

public class DoneOrder implements IDoneOrder {

    private final ITicket ticket;
    private final List<Pizza> pizzaList;

    public DoneOrder(ITicket ticket, List<Pizza> pizzaList) {
        this.ticket = ticket;
        this.pizzaList = pizzaList;
    }

    @Override
    public ITicket getTicket() {
        return this.ticket;
    }

    @Override
    public List<Pizza> getItems() {
        return this.pizzaList;
    }

    @Override
    public String toString() {
        return "DoneOrder{" +
                "ticket=" + ticket +
                ", pizzaList=" + pizzaList +
                '}';
    }
}

