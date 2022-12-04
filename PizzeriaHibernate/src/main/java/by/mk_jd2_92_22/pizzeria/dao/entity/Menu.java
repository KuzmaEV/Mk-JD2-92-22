package by.mk_jd2_92_22.pizzeria.dao.entity;

import by.mk_jd2_92_22.pizzeria.dao.entity.api.IMenu;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.IMenuRow;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Menu implements IMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "dt_create")
    private LocalDateTime dtCreate;

    @Column(name = "dt_update")
    private LocalDateTime dtUpdate;
    private String name;

    @OneToMany(targetEntity = MenuRow.class, mappedBy = "menu")
//    @JoinColumn(name = "id", referencedColumnName = "menu")
    private List<IMenuRow> items;

    @Column(name = "enable")
    private boolean isEnabled;

    public Menu() {
    }

    public Menu(long id, LocalDateTime dtCreate, LocalDateTime dtUpdate, String name, List<IMenuRow> menuRowList, boolean isEnabled) {
        this.id = id;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.name = name;
        this.items = menuRowList;
        this.isEnabled = isEnabled;
    }

    public Menu(LocalDateTime dtCreate, LocalDateTime dtUpdate, String name,  boolean isEnabled) {
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.name = name;
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
    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setItems(List<IMenuRow> items) {
        this.items = items;
    }

    @Override
    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
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
