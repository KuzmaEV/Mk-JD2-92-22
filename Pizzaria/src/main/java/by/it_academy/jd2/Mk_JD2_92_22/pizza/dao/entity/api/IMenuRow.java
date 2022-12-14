package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api;

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
