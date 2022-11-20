package by.it_academy.jd2.Mk_JD2_92_22.garbage;

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
