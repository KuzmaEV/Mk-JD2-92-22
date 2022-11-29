package by.it_academy.jd2.Mk_JD2_92_22.garbage.storages;

import by.it_academy.jd2.Mk_JD2_92_22.garbage.storages.api.IPizzaInfoStorage;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IPizzaInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryPizzaInfoStorage implements IPizzaInfoStorage {

    private final Map<String, IPizzaInfo> data = new HashMap<>();

    @Override
    public List<IPizzaInfo> get() {
        return new ArrayList<>(this.data.values());
    }

    @Override
    public IPizzaInfo get(String name) {

        return  this.data.get(name);
    }

    @Override
    public void save(IPizzaInfo item) {

        this.data.put(item.getName(),item);

    }

    @Override
    public void delete(String name) {
        System.out.println(name);

    }
}
