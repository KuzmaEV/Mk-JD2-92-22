package by.mk_jd2_92_22.pizzeria.services.singleton;

import by.mk_jd2_92_22.pizzeria.dao.sindleton.PizzaInfoDaoSingleton;
import by.mk_jd2_92_22.pizzeria.services.PizzaInfoService;
import by.mk_jd2_92_22.pizzeria.services.api.IPizzaInfoService;

public class PizzaInfoServiceSingleton {

    private final IPizzaInfoService service;
    private static PizzaInfoServiceSingleton instance;

    public PizzaInfoServiceSingleton() {
        this.service = new PizzaInfoService(PizzaInfoDaoSingleton.getInstance());
    }

    public static IPizzaInfoService getInstance(){
        if (instance == null){
            synchronized (PizzaInfoServiceSingleton.class){
                instance = new PizzaInfoServiceSingleton();
            }
        }
        return instance.service;
    }
}
