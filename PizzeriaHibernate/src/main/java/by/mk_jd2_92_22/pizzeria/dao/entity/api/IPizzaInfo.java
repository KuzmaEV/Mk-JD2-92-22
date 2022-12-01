package by.mk_jd2_92_22.pizzeria.dao.entity.api;

import java.time.LocalDateTime;

/**
 * Информация о пицце
 */
public interface IPizzaInfo {

    /**
     * @return id PizzaInfo
     */

    long getId();

    /**
     * @return Date create PizzaInfo
     */

    LocalDateTime getDtCreate();

    /**
     * @return Date update PizzaInfo
     */

    LocalDateTime getDtUpdate();

    /**
     * @return Название пиццы
     */
    String getName();

    /**
     * @return Описание/состав пиццы
     */
    String getDescription();

    /**
     * @return Итоговый размер пиццы которую приготовят
     */
    int getSize();


    void setName(String name);
    void setDescription(String description);
    void setSize(int size);
}
