package by.it_academy.jd2.Mk_JD2_92_22.pizza.api;

/**
 * Строчка меню
 */
public interface IMenuRow {
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

    String getId();

    void setId(String id);
}
