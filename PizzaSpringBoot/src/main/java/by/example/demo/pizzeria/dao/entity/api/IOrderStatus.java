package by.example.demo.pizzeria.dao.entity.api;

import by.example.demo.pizzeria.dao.entity.Stage;
import by.example.demo.pizzeria.dao.entity.api.ITicket;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Статус заказа выданный по определённому квитку
 */
public interface IOrderStatus {

    long getId();
    LocalDateTime getDtCreate();
    LocalDateTime getDtUpdate();

    /**
     * По какому квитку мы получили статус
     * @return По какому квитку мы получили статус
     */
    ITicket getTicket();

    /**
     * Получить список пройденных этапов
     * @return пройденные этапы заказа
     */
    List<Stage> getHistory();

    /**
     * Признак готовности заказа
     * @return true - готов, false - неготов
     */
    boolean isDone();

    void setDtUpdate(LocalDateTime dtUpdate);
    void setHistory(List<Stage> history);
    void setDone(boolean done);

}
