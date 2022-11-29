package by.mk_jd2_92_22.pizzeria.dao.entity.api.x;

import by.mk_jd2_92_22.pizzeria.dao.entity.api.ITicket;

import java.util.List;

/**
 * Готовый заказ
 */
public interface IDoneOrder {

    /**
     * Квиток по которому заказ готовился
     * @return квиток выданный при формировании заказа
     */
    ITicket getTicket();

    /**
     * Готовые пиццы приготовленные по заказу
     * @return список пицц
     */
    List<IPizza> getItems();
}
