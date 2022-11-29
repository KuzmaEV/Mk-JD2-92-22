package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api;

import java.time.LocalDateTime;

/**
 * Выбор покупателя
 */
public interface ISelectedItem2 {

    long getId();
    LocalDateTime getDtCreate();
    LocalDateTime getDtUpdate();
    /**
     * Выбранное из меню
     * @return Выбранное из меню
     */
    IMenuRow getRow();

    /**
     * Количество выбранного
     * @return Количество выбранного
     */
    int getCount();
}
