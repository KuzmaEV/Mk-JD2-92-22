package by.mk_jd2_92_22.pizzeria.dao.entity.api;

import by.mk_jd2_92_22.pizzeria.core.entity.api.IPizzaInfo;

import java.time.LocalDateTime;

/**
 * Строчка меню
 */
public interface IMenuRow {

    long getId();
    LocalDateTime getDtCreate();
    LocalDateTime getDtUpdate();

    /**
     *
     * @return Информация о пицце
     */
    IPizzaInfo getInfo();

    /**
     *
     * @return Стоимость пиццы
     */
    double getPrice();


    /**
     * @return Возращает Меню(покачто возращаен ИД Меню)
     */
    long getMenu();



}
