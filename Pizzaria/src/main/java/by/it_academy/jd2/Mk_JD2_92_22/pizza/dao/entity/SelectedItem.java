package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.ISelectedItem;


public class SelectedItem implements ISelectedItem {

    private final long id;
    private final IMenuRow row;
    private final int count;

    public SelectedItem(long id, IMenuRow row, int count) {
        this.id = id;
        this.row = row;
        this.count = count;
    }

    @Override
    public long getId() {
        return id;
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
