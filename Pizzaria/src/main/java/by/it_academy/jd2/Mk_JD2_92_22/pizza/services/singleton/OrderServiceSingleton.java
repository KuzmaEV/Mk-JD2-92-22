package by.it_academy.jd2.Mk_JD2_92_22.pizza.services.singleton;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.sindleton.OrderDaoSingleton;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.OrderService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IOrderService;

import java.beans.PropertyVetoException;

public class OrderServiceSingleton {

    private static OrderServiceSingleton instance;
    private final IOrderService service;

    public OrderServiceSingleton() throws PropertyVetoException {
        this.service = new OrderService(OrderDaoSingleton.getInstance());
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
