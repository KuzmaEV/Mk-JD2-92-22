package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.core;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.x.IPizza;

public class Pizza implements IPizza {

    private String name;
    private int size;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
