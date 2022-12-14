package by.example.demo.pizzeria.dao.entity.api;

import by.example.demo.pizzeria.dao.entity.Order;

import java.time.LocalDateTime;

/**
 * Квиток выдаваемый к заказу
 */
public interface ITicket {

    /**
     * Уникальный номер заказа
     * @return Уникальный номер заказа
     */
    long getId();

    /**
     * Когда заказ получен
     * @return Когда заказ получен
     */
    LocalDateTime getCreateAt();

    /**
     * Заказ для которого выдали квиток
     * @return Заказ для которого выдали квиток
     */
    Order getOrder();

    void setOrder(Order order);
}
