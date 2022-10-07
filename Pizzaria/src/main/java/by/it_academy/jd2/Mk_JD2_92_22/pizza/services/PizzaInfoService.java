package by.it_academy.jd2.Mk_JD2_92_22.pizza.services;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IMenuService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IPizzaInfoService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.storages.api.IPizzaInfoStorage;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.storages.entity.factory.PizzaInfoFactory;

import java.util.List;

public class PizzaInfoService implements IPizzaInfoService {

    private static final PizzaInfoService instance = new PizzaInfoService();
    private final IPizzaInfoStorage storage;

    private PizzaInfoService() {
        this.storage = PizzaInfoFactory.getInstance().getPizzaInfoStorage();
    }

    @Override
    public List<IPizzaInfo> get() {
        return this.storage.get();
    }

    @Override
    public IPizzaInfo get(String name) {
        return this.storage.get(name);
    }

    @Override
    public void validate(IPizzaInfo item) {

        this.storage.save(item);
    }

    public static PizzaInfoService getInstance(){
        return instance;
    }
}
