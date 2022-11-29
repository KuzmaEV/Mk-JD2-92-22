package by.mk_jd2_92_22.pizzeria.dao.entity;

import by.mk_jd2_92_22.pizzeria.dao.entity.api.IMenuRow;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.ISelectedItem;


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
