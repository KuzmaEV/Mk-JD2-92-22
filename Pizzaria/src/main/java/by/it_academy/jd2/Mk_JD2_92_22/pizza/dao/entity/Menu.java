package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenu;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenuRow;


import java.time.LocalDateTime;
import java.util.List;

public class Menu implements IMenu {

    private final long id;
    private final LocalDateTime dtCreate;
    private final LocalDateTime dtUpdate;
    private final String name;
    private final  List<IMenuRow> items;
    private final boolean isEnabled;

    public Menu(long id, LocalDateTime dtCreate, LocalDateTime dtUpdate, String name, List<IMenuRow> menuRowList, boolean isEnabled) {
        this.id = id;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.name = name;
        this.items = menuRowList;
        this.isEnabled = isEnabled;
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
    public String getName() {
        return name;
    }


    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public List<IMenuRow> getItems() {
//        menuRowList.add(new MenuRow("pepperoni", "sausage/cheese", 40, 12));
        return items;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", dtCreate=" + dtCreate +
                ", dtUpdate=" + dtUpdate +
                ", name='" + name + '\'' +
                ", menuRowList=" + items +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
