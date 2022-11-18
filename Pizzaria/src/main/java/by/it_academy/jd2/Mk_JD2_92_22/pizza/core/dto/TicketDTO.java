package by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto;

import java.time.LocalDateTime;

public class TicketDTO {

    private long order;
    private LocalDateTime dtCreate;

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }
}
