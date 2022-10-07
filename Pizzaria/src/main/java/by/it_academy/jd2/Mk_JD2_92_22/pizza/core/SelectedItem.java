package by.it_academy.jd2.Mk_JD2_92_22.pizza.core;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.ISelectedItem;

public class SelectedItem implements ISelectedItem {

    private IMenuRow row;
    private int count;

//    public SelectedItem(IMenuRow row, int count) {
//        this.row = row;
//        this.count = count;
//    }

    @Override
    public IMenuRow getRow() {
        return this.row;
    }

    @Override
    public int getCount() {
        return this.count;
    }
}
