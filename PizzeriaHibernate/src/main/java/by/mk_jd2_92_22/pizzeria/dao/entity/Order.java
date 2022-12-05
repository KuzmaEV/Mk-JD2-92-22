package by.mk_jd2_92_22.pizzeria.dao.entity;

import by.mk_jd2_92_22.pizzeria.dao.entity.api.IOrder;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.ISelectedItem;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Order implements IOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "dt_create")
    private LocalDateTime dtCreate;
    @Column(name = "dt_update")
    private LocalDateTime dtUpdate;

    @OneToMany
    private List<ISelectedItem> selectedItem;

    public Order() {
    }

    public Order(LocalDateTime dtCreate, LocalDateTime dtUpdate, List<ISelectedItem> selectedItem) {
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.selectedItem = selectedItem;
    }

    public Order(long id, LocalDateTime dtCreate, LocalDateTime dtUpdate, List<ISelectedItem> selectedItems) {
        this.id = id;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.selectedItem = selectedItems;
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
    public List<ISelectedItem> getSelectedItem() {
        return selectedItem;
    }

    @Override
    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    @Override
    public void setSelectedItem(List<ISelectedItem> selectedItem) {
        this.selectedItem = selectedItem;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dtCreate=" + dtCreate +
                ", dtUpdate=" + dtUpdate +
                ", selectedItem=" + selectedItem +
                '}';
    }
}

