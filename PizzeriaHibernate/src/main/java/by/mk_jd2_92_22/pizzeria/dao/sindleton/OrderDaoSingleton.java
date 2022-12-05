package by.mk_jd2_92_22.pizzeria.dao.sindleton;

import by.mk_jd2_92_22.pizzeria.dao.EntityManagerUtil;
import by.mk_jd2_92_22.pizzeria.dao.OrderDao;
import by.mk_jd2_92_22.pizzeria.dao.api.IOrderDao;

import java.beans.PropertyVetoException;

public class OrderDaoSingleton {

    private static OrderDaoSingleton instance;
    private final IOrderDao dao;

    public OrderDaoSingleton() {
        this.dao = new OrderDao(EntityManagerUtil.getEntityManager());
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
