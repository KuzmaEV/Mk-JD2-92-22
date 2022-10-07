package by.it_academy.jd2.Mk_JD2_92_22.pizza.core;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IOrderStatus;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IStage;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.ITicket;

import java.util.ArrayList;
import java.util.List;

public class OrderStatus implements IOrderStatus {

    private List<IStage> history = new ArrayList<>();
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
