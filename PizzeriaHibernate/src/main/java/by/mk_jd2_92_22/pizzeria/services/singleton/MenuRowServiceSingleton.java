package by.mk_jd2_92_22.pizzeria.services.singleton;


import by.mk_jd2_92_22.pizzeria.dao.sindleton.MenuRowDaoSingleton;
import by.mk_jd2_92_22.pizzeria.services.MenuRowService;
import by.mk_jd2_92_22.pizzeria.services.api.IMenuRowService;

public class MenuRowServiceSingleton {

    private final IMenuRowService service;
    private static MenuRowServiceSingleton instance;

    public MenuRowServiceSingleton(){
        service = new MenuRowService(MenuRowDaoSingleton.getInstance());
    }

    public static IMenuRowService getInstance(){
        if (instance == null){
            synchronized (MenuRowServiceSingleton.class){
                instance = new MenuRowServiceSingleton();
            }
        }
    return instance.service;
    }
}
