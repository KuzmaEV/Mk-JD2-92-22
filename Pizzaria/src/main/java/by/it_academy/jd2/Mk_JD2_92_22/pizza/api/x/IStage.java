package by.it_academy.jd2.Mk_JD2_92_22.pizza.api.x;

import java.time.LocalTime;

/**
 * Описание этапа выполнения заказа
 */
public interface IStage {
    /**
     * Описание этапа
     * @return Описание этапа
     */
    String getDescription();

    /**
     * Когда этап был начат
     * @return Когда этап был начат
     */
    LocalTime getTime();
}
