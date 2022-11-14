package by.it_academy.jd2.Mk_JD2_92_22.pizza.services.singleton;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.sindleton.MenuDaoSingleton;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IMenuService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.MenuService;

import java.beans.PropertyVetoException;

public class MenuServiceSingleton {

    private static MenuServiceSingleton instance;
    private final IMenuService service;

    public MenuServiceSingleton() throws PropertyVetoException {
        service = new MenuService(MenuDaoSingleton.getInstance());
    }

    public static IMenuService getInstance() throws PropertyVetoException {
        if (instance == null){
            synchronized (MenuServiceSingleton.class){
                instance = new MenuServiceSingleton();
            }
        }
        return instance.service;
    }
}
