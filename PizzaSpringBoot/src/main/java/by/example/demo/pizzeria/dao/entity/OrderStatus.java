package by.example.demo.pizzeria.dao.entity;

import by.example.demo.pizzeria.dao.entity.api.ITicket;
import by.example.demo.pizzeria.dao.entity.api.IOrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="order_status")
public class OrderStatus implements IOrderStatus {

    @Id
    private long id;

    @Column(name="dt_create")
    private LocalDateTime dtCreate;

    @Version
    @Column(name="dt_update")
    private LocalDateTime dtUpdate;

    @OneToMany(mappedBy = "orderStatus")
    private List<Stage> history = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "ticket", referencedColumnName = "id")
    private Ticket ticket;
    @Column
    private boolean done;

    public OrderStatus() {
    }

    public OrderStatus(LocalDateTime dt_create, LocalDateTime dt_update, List<Stage> history, Ticket ticket, boolean done) {
        this.dtCreate = dt_create;
        this.dtUpdate = dt_update;
        this.history = history;
        this.ticket = ticket;
        this.done = done;
    }

    public OrderStatus(long id, LocalDateTime dtCreate, LocalDateTime dtUpdate, List<Stage> history, Ticket ticket, boolean done) {
        this.id = id;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.history = history;
        this.ticket = ticket;
        this.done = done;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    @Override
    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    @Override
    public ITicket getTicket() {
        return this.ticket;
    }

    @Override
    public List<Stage> getHistory() {
        return this.history;
    }

    @Override
    public boolean isDone() {
        return this.done;
    }

    @Override
    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    @Override
    public void setHistory(List<Stage> history) {
        this.history = history;
    }

    @Override
    public void setDone(boolean done) {
        this.done = done;
    }
}
