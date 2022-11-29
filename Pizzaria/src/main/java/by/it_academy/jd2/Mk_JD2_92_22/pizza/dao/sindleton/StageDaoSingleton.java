package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.sindleton;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.StageDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.DataSourceCreator;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IStageDao;

import java.beans.PropertyVetoException;

public class StageDaoSingleton {
    private static StageDaoSingleton instance;
    private final IStageDao dao;

    public StageDaoSingleton() throws PropertyVetoException {
        dao = new StageDao(DataSourceCreator.getInstance());
    }

    public static IStageDao getInstance() throws PropertyVetoException {
        if (instance == null){
            synchronized (StageDaoSingleton.class){
                instance = new StageDaoSingleton();
            }
        }
        return instance.dao;
    }
}
