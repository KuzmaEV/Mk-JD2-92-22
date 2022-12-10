package by.mk_jd2_92_22.pizzeria.dao.entity.api;

import by.mk_jd2_92_22.pizzeria.dao.entity.PizzaInfo;

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
    PizzaInfo getInfo();

    /**
     *
     * @return Стоимость пиццы
     */
    double getPrice();


    /**
     * @return Возращает Меню(покачто возращаен ИД Меню)
     */
    long getMenu();

    void setDtUpdate(LocalDateTime dtUpdate);
    void setInfo(PizzaInfo pizzaInfo);
    void setPrice(double price);
    void setMenu(long menu);



}
