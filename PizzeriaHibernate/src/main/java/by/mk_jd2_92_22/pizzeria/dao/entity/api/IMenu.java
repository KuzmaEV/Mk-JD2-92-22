package by.mk_jd2_92_22.pizzeria.dao.entity.api;

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
    List<IMenuRow> getItems();

    /**
     *
     * @return доступно ли меню
     */
    boolean isEnabled();

    void setDtUpdate(LocalDateTime dtUpdate);
    void setName(String name);
    void setItems(List<IMenuRow> items);
    void setEnabled(boolean enable);
}