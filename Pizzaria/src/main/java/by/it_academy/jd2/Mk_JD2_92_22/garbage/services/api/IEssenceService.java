package by.it_academy.jd2.Mk_JD2_92_22.garbage.services.api;

import java.util.List;

public interface IEssenceService<T> {

    List<T> get();
    T get(String name);
    void validate(T item);
    void delete(String name);
}
