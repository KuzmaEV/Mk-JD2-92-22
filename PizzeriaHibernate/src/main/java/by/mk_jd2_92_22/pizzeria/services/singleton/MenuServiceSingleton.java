package by.mk_jd2_92_22.pizzeria.services.singleton;

import by.mk_jd2_92_22.pizzeria.dao.sindleton.MenuDaoSingleton;
import by.mk_jd2_92_22.pizzeria.services.MenuService;
import by.mk_jd2_92_22.pizzeria.services.api.IMenuService;

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
