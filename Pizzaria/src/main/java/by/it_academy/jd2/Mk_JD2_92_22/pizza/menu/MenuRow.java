package by.it_academy.jd2.Mk_JD2_92_22.pizza.menu;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;

public class MenuRow implements IMenuRow {

    private IPizzaInfo pizzaInfo;
    private int price;

//    private String name;
//    private String description;
//    private int size;

//    public MenuRow(String name, String description, int size, int price) {
//        this.name = name;
//        this.description = description;
//        this.size = size;
//        this.price = price;
//        pizzaInfo = new PizzaInfo(name, description, size);
//    }

    @Override
    public IPizzaInfo getInfo() {
        return this.pizzaInfo;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
