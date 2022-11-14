package by.it_academy.jd2.Mk_JD2_92_22.pizza.services.singleton;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.sindleton.PizzaInfoDaoSingleton;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.PizzaInfoService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IPizzaInfoService;

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
