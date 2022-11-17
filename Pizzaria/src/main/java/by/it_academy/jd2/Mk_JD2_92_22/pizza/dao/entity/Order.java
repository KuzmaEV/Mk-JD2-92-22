package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IOrder;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.ISelectedItem;

import java.time.LocalDateTime;
import java.util.List;

public class Order implements IOrder {

    private final long id;
    private final LocalDateTime dtCreate;
    private final LocalDateTime dtUpdate;

    private final List<ISelectedItem> selectedItem;

    public Order(long id, LocalDateTime dtCreate, LocalDateTime dtUpdate, List<ISelectedItem> selectedItems) {
        this.id = id;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.selectedItem = selectedItems;
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
    public List<ISelectedItem> getSelectedItem() {
        return selectedItem;
    }
}

