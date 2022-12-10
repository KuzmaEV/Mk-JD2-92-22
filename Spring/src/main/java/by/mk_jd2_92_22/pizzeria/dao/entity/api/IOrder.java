package by.mk_jd2_92_22.pizzeria.dao.entity.api;

import by.mk_jd2_92_22.pizzeria.dao.entity.SelectedItem;

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
    List<SelectedItem> getSelectedItem();

    void setDtUpdate(LocalDateTime dtUpdate);
    void setSelectedItem(List<SelectedItem> SelectedItem);
}
