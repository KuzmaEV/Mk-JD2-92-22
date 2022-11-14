package by.it_academy.jd2.Mk_JD2_92_22.pizza.core;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.x.IStage;

import java.time.LocalTime;

public class Stage implements IStage {

    private String description;
    private LocalTime time;

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public LocalTime getTime() {
        return this.time;
    }
}
