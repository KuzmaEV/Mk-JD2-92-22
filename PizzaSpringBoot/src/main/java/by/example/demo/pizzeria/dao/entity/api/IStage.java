package by.example.demo.pizzeria.dao.entity.api;

import java.time.LocalTime;

/**
 * Описание этапа выполнения заказа
 */
public interface IStage {

    long getId();
//    LocalDateTime getDtCreate();
//    LocalDateTime getDtUpdate();
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
    long getOrderStatus();

//    void setDtUpdate(LocalDateTime dtUpdate);
    void setDescription(String description);
}
