package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.sindleton;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.OrderDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.DataSourceCreator;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IOrderDao;

import java.beans.PropertyVetoException;

public class OrderDaoSingleton {

    private static OrderDaoSingleton instance;
    private final IOrderDao dao;

    public OrderDaoSingleton() throws PropertyVetoException {
        this.dao = new OrderDao(DataSourceCreator.getInstance());
    }

    public static IOrderDao getInstance() throws PropertyVetoException {
        if (instance == null){
            synchronized (OrderDaoSingleton.class){
                instance = new OrderDaoSingleton();
            }
        }
        return instance.dao;
    }
}
