package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.sindleton;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.MenuDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.DataSourceCreator;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IMenuDao;

import java.beans.PropertyVetoException;

public class MenuDaoSingleton {

    private static MenuDaoSingleton instance;
    private final IMenuDao menu;

    public MenuDaoSingleton() throws PropertyVetoException {
        this.menu = new MenuDao(DataSourceCreator.getInstance());
    }

    public static IMenuDao getInstance() throws PropertyVetoException {

        if (instance == null){
            synchronized (MenuDaoSingleton.class){
                instance = new MenuDaoSingleton();
            }
        }
        return instance.menu;
    }
}
