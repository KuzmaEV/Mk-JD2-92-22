package by.mk_jd2_92_22.pizzeria.services.singleton;

import by.mk_jd2_92_22.pizzeria.dao.sindleton.MenuDaoSingleton;
import by.mk_jd2_92_22.pizzeria.services.MenuService;
import by.mk_jd2_92_22.pizzeria.services.api.IMenuService;

public class MenuServiceSingleton {

    private static MenuServiceSingleton instance;
    private final IMenuService service;

    public MenuServiceSingleton() {
        this.service = new MenuService(MenuDaoSingleton.getInstance());
    }

    public static IMenuService getInstance() {
        if (instance == null){
            synchronized (MenuServiceSingleton.class){
                instance = new MenuServiceSingleton();
            }
        }
        return instance.service;
    }
}
