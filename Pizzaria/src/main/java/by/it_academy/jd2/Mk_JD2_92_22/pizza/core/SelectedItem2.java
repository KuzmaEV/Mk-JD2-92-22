package by.it_academy.jd2.Mk_JD2_92_22.pizza.core;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.ISelectedItem2;

import java.time.LocalDateTime;

public class SelectedItem2 implements ISelectedItem2 {

    private final long id;
    private final LocalDateTime dtCreate;
    private final LocalDateTime dtUpdate;
    private final IMenuRow row;
    private final int count;

    public SelectedItem2(long id, LocalDateTime dtCreate, LocalDateTime dtUpdate, IMenuRow row, int count) {
        this.id = id;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.row = row;
        this.count = count;
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
    public IMenuRow getRow() {
        return this.row;
    }

    @Override
    public int getCount() {
        return this.count;
    }
}
