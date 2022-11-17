package by.it_academy.jd2.Mk_JD2_92_22.pizza.api;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Заказ сформированный покупателем
 */
public interface IOrder {

    long getId();
    LocalDateTime getDtCreate();
    LocalDateTime getDtUpdate();


    /**
     * Список выбранного для заказа
     * @return список выбранного
     */
    List<ISelectedItem> getSelectedItem();
}
