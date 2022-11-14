package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.sindleton;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.PizzaInfoDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.DataSourceCreator;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IPizzaInfoDao;

import java.beans.PropertyVetoException;

public class PizzaInfoDaoSingleton {
    private static PizzaInfoDaoSingleton instance;
    private final IPizzaInfoDao pizzaInfoDao;

    public PizzaInfoDaoSingleton() {
        try {
            pizzaInfoDao = new PizzaInfoDao(DataSourceCreator.getInstance());
        } catch (PropertyVetoException e) {
            throw new RuntimeException("Проблемы с созданием слоя доступа к данным", e);
        }
    }

    public static IPizzaInfoDao getInstance(){
        if (instance == null){
            synchronized (PizzaInfoDaoSingleton.class){
                    instance = new PizzaInfoDaoSingleton();
            }
        }
        return instance.pizzaInfoDao;
    }
}
