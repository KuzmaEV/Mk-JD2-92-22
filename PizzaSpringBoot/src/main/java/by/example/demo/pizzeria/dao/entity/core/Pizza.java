package by.example.demo.pizzeria.dao.entity.core;

import by.example.demo.pizzeria.dao.entity.api.x.IPizza;

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
