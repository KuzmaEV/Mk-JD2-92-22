package by.example.demo.pizzeria.dao.entity.api;

/**
 * Приготовленная пицца
 */
public interface IPizza {
    /**
     * Название пиццы
     * @return Название пиццы
     */
    String getName();

    /**
     * Размер пиццы
     * @return Размер пиццы
     */
    int getSize();
}
