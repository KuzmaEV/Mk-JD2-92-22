package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.sindleton;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.TicketDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.DataSourceCreator;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.ITicketDao;

import java.beans.PropertyVetoException;

public class TicketDaoSingleton {

    private static TicketDaoSingleton instance;
    private final ITicketDao dao;

    public TicketDaoSingleton() throws PropertyVetoException {
        dao = new TicketDao(DataSourceCreator.getInstance());
    }

    public static ITicketDao getInstance() throws PropertyVetoException {
        if (instance == null){
            synchronized (TicketDaoSingleton.class){
                instance = new TicketDaoSingleton();
            }
        }
        return instance.dao;
    }
}
