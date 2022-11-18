package by.it_academy.jd2.Mk_JD2_92_22.pizza.core;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.x.IDoneOrder;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.x.IPizza;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.ITicket;

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
