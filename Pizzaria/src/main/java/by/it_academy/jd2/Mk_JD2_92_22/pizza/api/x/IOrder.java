package by.it_academy.jd2.Mk_JD2_92_22.pizza.api.x;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.ISelectedItem;

import java.util.List;

/**
 * Заказ сформированный покупателем
 */
public interface IOrder {

    /**
     * Список выбранного для заказа
     * @return список выбранного
     */
    List<ISelectedItem> getSelected();
}
