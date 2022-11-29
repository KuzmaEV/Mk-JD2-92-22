package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.core;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IStage;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Stage implements IStage {

    private final long id;
    private final LocalDateTime dtCreate;
    private final LocalDateTime dtUpdate;

    private final String description;
    private LocalTime time;

    public Stage(long id, LocalDateTime dtCreate, LocalDateTime dtUpdate, String description) {
        this.id = id;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.description = description;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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
    public String getDescription() {
        return this.description;
    }

    @Override
    public LocalTime getTime() {
        return this.time;
    }
}
