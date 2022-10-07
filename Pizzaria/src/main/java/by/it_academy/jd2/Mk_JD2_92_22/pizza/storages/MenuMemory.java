package by.it_academy.jd2.Mk_JD2_92_22.pizza.storages;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.storages.api.IMenuStorage;

import java.util.List;

public class MenuMemory implements IMenuStorage {

    private List<IMenuRow> menuRowList;

    @Override
    public List get() {
        return null;
    }

    @Override
    public Object get(String name) {
        return null;
    }

    @Override
    public void save(Object item) {

    }
}
