package by.it_academy.jd2.Mk_JD2_92_22.garbage.services;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.garbage.services.api.IPizzaInfoService;
import by.it_academy.jd2.Mk_JD2_92_22.garbage.storages.api.IPizzaInfoStorage;
import by.it_academy.jd2.Mk_JD2_92_22.garbage.storages.entity.factory.PizzaInfoFactory;

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

        if(storage.get(item.getName()) == null) {
            this.storage.save(item);
        }
        else throw new IllegalArgumentException("PizzaInfo is existed");
    }

    @Override
    public void delete(String name) {
        if(storage.get(name) != null) {
            this.storage.delete(name);
        }
        else throw new IllegalArgumentException("PizzaInfo hasn't existed");
    }

    public static PizzaInfoService getInstance(){
        return instance;
    }
}
