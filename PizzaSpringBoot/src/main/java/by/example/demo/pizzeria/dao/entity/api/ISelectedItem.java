package by.example.demo.pizzeria.dao.entity.api;

import by.example.demo.pizzeria.dao.entity.MenuRow;

/**
 * Выбор покупателя
 */
public interface ISelectedItem {

    long getId();

    /**
     * Выбранное из меню
     * @return Выбранное из меню
     */
    MenuRow getMenuRow();

    /**
     * Количество выбранного
     * @return Количество выбранного
     */
    int getCount();
//    long getOrder();

    void setMenuRow(MenuRow menuRow);
    void  setCount(int count);
//    void  setOrder(long order);
}
