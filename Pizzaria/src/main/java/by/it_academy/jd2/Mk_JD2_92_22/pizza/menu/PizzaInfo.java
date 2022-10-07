package by.it_academy.jd2.Mk_JD2_92_22.pizza.menu;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;

public class PizzaInfo implements IPizzaInfo {

    private String name;
    private String description;
    private int size;

    public PizzaInfo() {
    }

    public PizzaInfo(String name, String description, int size) {
        this.name = name;
        this.description = description;
        this.size = size;
    }



    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getSize() {
        return size;
    }
}
