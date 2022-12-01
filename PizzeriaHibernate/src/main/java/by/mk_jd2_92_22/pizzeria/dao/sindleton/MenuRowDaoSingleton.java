package by.mk_jd2_92_22.pizzeria.dao.sindleton;

import by.mk_jd2_92_22.pizzeria.dao.EntityManagerUtil;
import by.mk_jd2_92_22.pizzeria.dao.MenuRowDao;
import by.mk_jd2_92_22.pizzeria.dao.api.IMenuRowDao;


public class MenuRowDaoSingleton {

    private final IMenuRowDao dao;
    private static MenuRowDaoSingleton instance;

    public MenuRowDaoSingleton(){
        this.dao = new MenuRowDao(EntityManagerUtil.getEntityManager());
    }

    public static IMenuRowDao getInstance(){
        if (instance == null){
            synchronized (MenuRowDaoSingleton.class){
                instance = new MenuRowDaoSingleton();
            }
        }
        return instance.dao;
    }
}
