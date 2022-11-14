package by.it_academy.jd2.Mk_JD2_92_22.pizza.services;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.sindleton.MenuRowDaoSingleton;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IMenuRowService;

import java.beans.PropertyVetoException;

public class MenuRowServiceSingleton {

    private final IMenuRowService service;
    private static MenuRowServiceSingleton instance;

    public MenuRowServiceSingleton() throws PropertyVetoException {
        service = new MenuRowService(MenuRowDaoSingleton.getInstance());
    }

    public static IMenuRowService getInstance() throws PropertyVetoException {
        if (instance == null){
            synchronized (MenuRowServiceSingleton.class){
                instance = new MenuRowServiceSingleton();
            }
        }
    return instance.service;
    }
}
