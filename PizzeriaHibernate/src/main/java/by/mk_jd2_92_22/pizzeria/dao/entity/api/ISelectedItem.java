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
    IMenuRow getMenuRow();

    /**
     * Количество выбранного
     * @return Количество выбранного
     */
    int getCount();
    long getOrder();

    void setMenuRow(IMenuRow menuRow);
    void  setCount(int count);
    void  setOrder(long order);
}
