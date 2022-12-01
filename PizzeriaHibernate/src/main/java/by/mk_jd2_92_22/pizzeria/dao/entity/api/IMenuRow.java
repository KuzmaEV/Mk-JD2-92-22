package by.mk_jd2_92_22.pizzeria.dao.entity.api;

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

    void setDtUpdate(LocalDateTime dtUpdate);
    void setInfo(IPizzaInfo pizzaInfo);
    void setPrise(double prise);
    void setMenu(long menu);



}
