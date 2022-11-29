package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api;

/**
 * Выбор покупателя
 */
public interface ISelectedItem {

    long getId();

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
