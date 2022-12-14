package by.mk_jd2_92_22.pizzeria.dao.entity.core;

import by.mk_jd2_92_22.pizzeria.dao.entity.api.IStage;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.ITicket;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.x.IOrderStatus;

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
