package by.mk_jd2_92_22.pizzeria.dao.entity;

import by.mk_jd2_92_22.pizzeria.dao.entity.api.IPizzaInfo;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.IMenuRow;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "menu_row")
public class MenuRow implements IMenuRow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "dt_create")
    private LocalDateTime dtCreate;

    @Column(name = "dt_update")
    private LocalDateTime dtUpdate;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = PizzaInfo.class)
    @JoinColumn(name = "info", referencedColumnName = "id")
    private IPizzaInfo info;

    private double price;
    private long menu;

    public MenuRow() {
    }

    public MenuRow(LocalDateTime dtCreate, LocalDateTime dtUpdate, IPizzaInfo info, double price, long menu) {
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.info = info;
        this.price = price;
        this.menu = menu;
    }

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
    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    @Override
    public void setInfo(IPizzaInfo info) {
        this.info = info;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setMenu(long menu) {
        this.menu = menu;
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
