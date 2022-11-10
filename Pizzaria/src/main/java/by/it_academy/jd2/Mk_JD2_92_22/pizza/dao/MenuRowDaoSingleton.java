package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.DataSourceCreator;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IMenuRowDao;

import java.beans.PropertyVetoException;

public class MenuRowDaoSingleton {

    private final IMenuRowDao dao;
    private static MenuRowDaoSingleton instance;

    public MenuRowDaoSingleton() throws PropertyVetoException {
        this.dao = new MenuRowDao(DataSourceCreator.getInstance());
    }

    public static IMenuRowDao getInstance() throws PropertyVetoException {
        if (instance == null){
            synchronized (MenuRowDaoSingleton.class){
                instance = new MenuRowDaoSingleton();
            }
        }
        return instance.dao;
    }
}
