package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.core;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.x.IOrderStatus;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IStage;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.ITicket;

import java.util.ArrayList;
import java.util.List;

public class OrderStatus implements IOrderStatus {

    private final List<IStage> history = new ArrayList<>();
    private ITicket ticket;
    private boolean done;

    @Override
    public ITicket getTicket() {
        return this.ticket;
    }

    @Override
    public List<IStage> getHistory() {
        return this.history;
    }

    @Override
    public boolean isDone() {
        return this.done;
    }
}
