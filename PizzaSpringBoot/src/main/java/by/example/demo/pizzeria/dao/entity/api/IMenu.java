package by.example.demo.pizzeria.dao.entity.api;

import by.example.demo.pizzeria.dao.entity.MenuRow;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Меню
 */
public interface IMenu {

    long getId();
    LocalDateTime getDtCreate();
    LocalDateTime getDtUpdate();

    /**
     *
     * @return name Menu
     */
    String getName();

    /**
     * Доступные к заказу пункты
     * @return пункты которые можно заказать
     */
    List<MenuRow> getItems();

    /**
     *
     * @return доступно ли меню
     */
    boolean isEnabled();

    void setDtUpdate(LocalDateTime dtUpdate);
    void setName(String name);
    void setItems(List<MenuRow> items);
    void setEnabled(boolean enable);
}
