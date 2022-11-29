package by.mk_jd2_92_22.pizzeria.dao.entity;

import by.mk_jd2_92_22.pizzeria.dao.entity.api.IOrder;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.ITicket;

import java.time.LocalDateTime;

public class Ticket implements ITicket {

    private final String number;
    private final LocalDateTime createAt;
    private final IOrder order;

    public Ticket(String number, LocalDateTime createAt, IOrder order) {
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
    public IOrder getOrder() {
        return order;
    }
}
