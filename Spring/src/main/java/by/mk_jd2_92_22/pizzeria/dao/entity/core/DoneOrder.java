package by.mk_jd2_92_22.pizzeria.dao.entity.core;


import by.mk_jd2_92_22.pizzeria.dao.entity.api.ITicket;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.x.IDoneOrder;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.x.IPizza;

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
