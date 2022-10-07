package by.it_academy.jd2.Mk_JD2_92_22.pizza.menu;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenu;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenuRow;


import java.util.List;

public class Menu implements IMenu {

    private  List<IMenuRow> menuRowList;

    @Override
    public List<IMenuRow> getItems() {
//        menuRowList.add(new MenuRow("pepperoni", "sausage/cheese", 40, 12));
        return menuRowList;
    }
}
