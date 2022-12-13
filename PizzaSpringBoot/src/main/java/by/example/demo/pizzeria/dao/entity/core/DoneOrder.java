package by.example.demo.pizzeria.dao.entity.core;


import by.example.demo.pizzeria.dao.entity.api.ITicket;
import by.example.demo.pizzeria.dao.entity.api.x.IDoneOrder;
import by.example.demo.pizzeria.dao.entity.api.x.IPizza;

import java.util.List;

public class DoneOrder implements IDoneOrder {

    private ITicket ticket;
    private List<IPizza> pizzaList;


    @Override
    public ITicket getTicket() {
        return this.ticket;
    }

    @Override
    public List<IPizza> getItems() {
        return this.pizzaList;
    }
}
