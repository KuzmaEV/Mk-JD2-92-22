package by.mk_jd2_92_22.pizzeria.dao.entity;

import by.mk_jd2_92_22.pizzeria.dao.entity.api.IMenuRow;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.ISelectedItem;

import javax.persistence.*;

@Entity
public class SelectedItem implements ISelectedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private IMenuRow menuRow;
    private int count;
    private long order;

    public SelectedItem() {
    }

    public SelectedItem(long id, IMenuRow menuRow, int count, long order) {
        this.id = id;
        this.menuRow = menuRow;
        this.count = count;
        this.order = order;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public IMenuRow getMenuRow() {
        return this.menuRow;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public void setMenuRow(IMenuRow menuRow) {
        this.menuRow = menuRow;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public long getOrder() {
        return order;
    }

    @Override
    public void setOrder(long order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "SelectedItem{" +
                "id=" + id +
                ", menuRow=" + menuRow +
                ", count=" + count +
                ", order=" + order +
                '}';
    }
}
