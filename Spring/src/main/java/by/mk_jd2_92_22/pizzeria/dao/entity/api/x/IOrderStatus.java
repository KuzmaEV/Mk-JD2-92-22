package by.mk_jd2_92_22.pizzeria.dao.entity.api.x;

import by.mk_jd2_92_22.pizzeria.dao.entity.api.IStage;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.ITicket;

import java.util.List;

/**
 * Статус заказа выданный по определённому квитку
 */
public interface IOrderStatus {

    /**
     * По какому квитку мы получили статус
     * @return По какому квитку мы получили статус
     */
    ITicket getTicket();

    /**
     * Получить список пройденных этапов
     * @return пройденные этапы заказа
     */
    List<IStage> getHistory();

    /**
     * Признак готовности заказа
     * @return true - готов, false - неготов
     */
    boolean isDone();
}
