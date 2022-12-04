package by.mk_jd2_92_22.pizzeria.dao.sindleton;


import by.mk_jd2_92_22.pizzeria.dao.EntityManagerUtil;
import by.mk_jd2_92_22.pizzeria.dao.MenuDao;
import by.mk_jd2_92_22.pizzeria.dao.api.IMenuDao;

public class MenuDaoSingleton {

    private static MenuDaoSingleton instance;
    private final IMenuDao menu;

    public MenuDaoSingleton(){
        this.menu = new MenuDao(EntityManagerUtil.getEntityManager());
    }

    public static IMenuDao getInstance(){

        if (instance == null){
            synchronized (MenuDaoSingleton.class){
                instance = new MenuDaoSingleton();
            }
        }
        return instance.menu;
    }
}
