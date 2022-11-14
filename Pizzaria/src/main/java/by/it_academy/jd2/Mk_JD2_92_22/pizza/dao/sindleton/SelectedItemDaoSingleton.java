package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.sindleton;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.SelectedItemDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.DataSourceCreator;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.ISelectedItemDao;

import java.beans.PropertyVetoException;

public class SelectedItemDaoSingleton {

    private static  SelectedItemDaoSingleton instance;
    private final ISelectedItemDao dao;

    public SelectedItemDaoSingleton() throws PropertyVetoException {
        dao = new SelectedItemDao(DataSourceCreator.getInstance());
    }

    public static ISelectedItemDao getInstance() throws PropertyVetoException {
        if (instance == null){
            synchronized (SelectedItemDaoSingleton.class){
                instance = new SelectedItemDaoSingleton();
            }
        }
        return instance.dao;
    }
}
