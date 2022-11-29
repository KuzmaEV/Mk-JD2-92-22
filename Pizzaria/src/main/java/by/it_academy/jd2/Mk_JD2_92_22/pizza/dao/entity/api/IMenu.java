package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api;

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
}
