package by.mk_jd2_92_22.pizzeria.dao.sindleton;


import by.mk_jd2_92_22.pizzeria.dao.EntityManagerUtil;
import by.mk_jd2_92_22.pizzeria.dao.PizzaInfoDao;
import by.mk_jd2_92_22.pizzeria.dao.api.IPizzaInfoDao;

import javax.persistence.EntityManager;


public class PizzaInfoDaoSingleton {
    private static PizzaInfoDaoSingleton instance;
    private final IPizzaInfoDao pizzaInfoDao;

    public PizzaInfoDaoSingleton() {
        
            pizzaInfoDao = new PizzaInfoDao(EntityManagerUtil.getEntityManager());
        
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
