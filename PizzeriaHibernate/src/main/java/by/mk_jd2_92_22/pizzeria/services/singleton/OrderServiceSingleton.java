package by.mk_jd2_92_22.pizzeria.services.singleton;

import by.mk_jd2_92_22.pizzeria.dao.sindleton.OrderDaoSingleton;
import by.mk_jd2_92_22.pizzeria.services.OrderService;
import by.mk_jd2_92_22.pizzeria.services.api.IOrderService;

import java.beans.PropertyVetoException;

public class OrderServiceSingleton {

    private static OrderServiceSingleton instance;
    private final IOrderService service;

    public OrderServiceSingleton() throws PropertyVetoException {
        this.service = new OrderService(OrderDaoSingleton.getInstance(), MenuRowServiceSingleton.getInstance());
    }

    public static IOrderService getInstance() throws PropertyVetoException {
        if (instance == null){
            synchronized (OrderServiceSingleton.class){
                instance = new OrderServiceSingleton();
            }
        }
        return instance.service;
    }
}
