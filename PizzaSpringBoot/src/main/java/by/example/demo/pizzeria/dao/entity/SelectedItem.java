package by.example.demo.pizzeria.dao.entity;

import by.example.demo.pizzeria.dao.entity.api.ISelectedItem;

import javax.persistence.*;

@Entity
@Table(name = "selected_item")
public class SelectedItem implements ISelectedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne/*(targetEntity = MenuRow.class)*/
    @JoinColumn(name = "menu_row")
    private MenuRow menuRow;
    @Column
    private int count;
//    @Column(name = "\"order\"")
//    private long order;

    public SelectedItem() {
    }

    public SelectedItem(MenuRow menuRow, int count) {
        this.menuRow = menuRow;
        this.count = count;
    }

    public SelectedItem(long id, MenuRow menuRow, int count) {
        this.id = id;
        this.menuRow = menuRow;
        this.count = count;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public MenuRow getMenuRow() {
        return this.menuRow;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public void setMenuRow(MenuRow menuRow) {
        this.menuRow = menuRow;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public String toString() {
        return "SelectedItem{" +
                "id=" + id +
                ", menuRow=" + menuRow +
                ", count=" + count +
                '}';
    }
}
