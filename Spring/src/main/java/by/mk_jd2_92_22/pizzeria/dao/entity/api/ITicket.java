package by.mk_jd2_92_22.pizzeria.dao.entity.api;

import by.mk_jd2_92_22.pizzeria.dao.entity.Order;

import java.time.LocalDateTime;

/**
 * Квиток выдаваемый к заказу
 */
public interface ITicket {

    /**
     * Уникальный номер заказа
     * @return Уникальный номер заказа
     */
    String getNumber();

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
}
