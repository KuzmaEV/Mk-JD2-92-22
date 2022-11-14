package by.it_academy.jd2.Mk_JD2_92_22.pizza.api.x;

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
    IOrder getOrder();
}
