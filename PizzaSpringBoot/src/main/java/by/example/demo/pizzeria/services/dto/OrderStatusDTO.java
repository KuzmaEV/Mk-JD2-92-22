package by.example.demo.pizzeria.services.dto;

import by.example.demo.pizzeria.dao.entity.Ticket;

public class OrderStatusDTO {

    private Ticket ticket;
    private long stage;
    private String stageDescription;
    private boolean done;

    public OrderStatusDTO() {
    }


    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public long getStage() {
        return stage;
    }

    public void setStage(long stage) {
        this.stage = stage;
    }

    public String getStageDescription() {
        return stageDescription;
    }

    public void setStageDescription(String stageDescription) {
        this.stageDescription = stageDescription;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
