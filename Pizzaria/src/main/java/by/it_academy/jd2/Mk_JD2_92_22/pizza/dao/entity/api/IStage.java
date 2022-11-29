package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Описание этапа выполнения заказа
 */
public interface IStage {

    long getId();
    LocalDateTime getDtCreate();
    LocalDateTime getDtUpdate();
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
