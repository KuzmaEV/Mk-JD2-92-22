package by.it_academy.jd2.Mk_JD2_92_22.garbage;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.DataSourceCreator;

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
