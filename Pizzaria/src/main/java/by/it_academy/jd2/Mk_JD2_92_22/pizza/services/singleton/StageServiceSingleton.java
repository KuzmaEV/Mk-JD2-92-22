package by.it_academy.jd2.Mk_JD2_92_22.pizza.services.singleton;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IStageDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.sindleton.StageDaoSingleton;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.StageService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IStageService;

import java.beans.PropertyVetoException;

public class StageServiceSingleton {
    private static StageServiceSingleton instance;
    private final IStageService service;

    public StageServiceSingleton() throws PropertyVetoException {
        service = new StageService(StageDaoSingleton.getInstance());
    }

    public static IStageService getInstance() throws PropertyVetoException {
        if (instance == null){
            synchronized (StageServiceSingleton.class){
                instance = new StageServiceSingleton();
            }
        }
        return instance.service;
    }
}
