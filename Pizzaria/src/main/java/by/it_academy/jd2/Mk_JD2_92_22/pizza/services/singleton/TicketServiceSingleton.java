package by.it_academy.jd2.Mk_JD2_92_22.pizza.services.singleton;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.sindleton.TicketDaoSingleton;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.TicketService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.ITicketService;

import java.beans.PropertyVetoException;

public class TicketServiceSingleton {

    private static TicketServiceSingleton instance;
    private final ITicketService service;

    public TicketServiceSingleton() throws PropertyVetoException {
        service = new TicketService(TicketDaoSingleton.getInstance());
    }

    public static ITicketService getInstance() throws PropertyVetoException {
        if (instance == null){
            synchronized (TicketServiceSingleton.class){
                instance = new TicketServiceSingleton();
            }
        }
        return instance.service;
    }
}
