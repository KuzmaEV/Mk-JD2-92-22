package by.it_academy.jd2.Mk_JD2_92_22.garbage.storages.api;

import java.util.List;

public interface IEssenceStorage <T>{
    List<T> get();
    T get (String name);
    void save(T item);
    void delete(String name);
}
