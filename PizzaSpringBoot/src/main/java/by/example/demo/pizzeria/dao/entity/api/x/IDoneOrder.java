package by.example.demo.pizzeria.dao.entity.api.x;

import by.example.demo.pizzeria.dao.entity.api.ITicket;
import by.example.demo.pizzeria.dao.entity.core.Pizza;

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
    List<Pizza> getItems();
}
