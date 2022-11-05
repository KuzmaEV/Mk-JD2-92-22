package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;

public class MenuRow implements IMenuRow {

//    private final FilePizzaInfoStorage pizzaInfoStorage = new FilePizzaInfoStorage();
    private IPizzaInfo info;
    private int price;
    private String id;

    public MenuRow() {
    }

    public MenuRow(PizzaInfo info, int price) {

        this.info = info;
        this.price = price;
    }

    @Override
    public IPizzaInfo getInfo() {

        return this.info;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
