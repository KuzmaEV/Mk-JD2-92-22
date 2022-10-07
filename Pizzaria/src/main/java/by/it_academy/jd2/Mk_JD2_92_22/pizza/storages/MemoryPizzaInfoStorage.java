package by.it_academy.jd2.Mk_JD2_92_22.pizza.storages;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.storages.api.IPizzaInfoStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryPizzaInfoStorage implements IPizzaInfoStorage {

    private final Map<Integer, IPizzaInfo> data = new HashMap<>();

    @Override
    public List get() {
        return new ArrayList(this.data.values());
    }

    @Override
    public IPizzaInfo get(String name) {

        return  this.data.get(name);
    }

    @Override
    public void save(IPizzaInfo item) {

        this.data.put(data.size(),item);

    }
}
