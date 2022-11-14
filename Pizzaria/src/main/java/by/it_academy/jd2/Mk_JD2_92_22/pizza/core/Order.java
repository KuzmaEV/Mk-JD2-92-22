package by.it_academy.jd2.Mk_JD2_92_22.pizza.core;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.x.IOrder;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.ISelectedItem;

import java.util.List;

public class Order implements IOrder {

    private List<ISelectedItem> selectedItems ;


    @Override
    public List<ISelectedItem> getSelected() {

        return this.selectedItems;
    }
}
