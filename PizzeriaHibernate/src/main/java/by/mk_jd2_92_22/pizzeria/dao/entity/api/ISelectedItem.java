package by.mk_jd2_92_22.pizzeria.dao.entity.api;

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
