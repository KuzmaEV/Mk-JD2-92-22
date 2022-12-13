package by.mk_jd2_92_22.pizzeria.dao.entity.api;

import java.time.LocalDateTime;

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

//    /**
//     * Когда этап был начат
//     * @return Когда этап был начат
//     */
//    LocalTime getTime();

    void setDtUpdate(LocalDateTime dtUpdate);
    void setDescription(String description);
}
