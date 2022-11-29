package by.mk_jd2_92_22.pizzeria.dao.entity;

import by.mk_jd2_92_22.pizzeria.core.entity.api.IPizzaInfo;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.IMenuRow;

import java.time.LocalDateTime;

public class MenuRow implements IMenuRow {

    private final long id;
    private final LocalDateTime dtCreate;
    private final LocalDateTime dtUpdate;

    private final IPizzaInfo info;
    private final double price;
    private final long menu;

    public MenuRow(long id, LocalDateTime dtCreate, LocalDateTime dtUpdate, IPizzaInfo info, double price, long menu) {
        this.id = id;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.info = info;
        this.price = price;
        this.menu = menu;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    @Override
    public IPizzaInfo getInfo() {
        return info;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public long getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return "MenuRow{" +
                "id=" + id +
                ", dtCreate=" + dtCreate +
                ", dtUpdate=" + dtUpdate +
                ", info=" + info +
                ", price=" + price +
                ", menu=" + menu +
                '}';
    }
}
