package by.it_academy.jd2.Mk_JD2_92_22.pizza.core;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IOrder;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.ITicket;

import java.time.LocalDateTime;

public class Ticket implements ITicket {

    private String number;
    private  LocalDateTime createAt;
    private    IOrder order;

//    public Ticket() {
//        this.createAt = LocalDateTime.now();
//        this.order = new Order();
//    }

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
