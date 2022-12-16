package by.example.demo.pizzeria.dao.entity;

import by.example.demo.pizzeria.dao.entity.api.IPizza;

public class Pizza implements IPizza {

    private final String name;
    private final int size;

    public Pizza(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
