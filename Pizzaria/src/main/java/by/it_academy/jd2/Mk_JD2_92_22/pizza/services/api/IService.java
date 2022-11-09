package by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api;

import java.time.LocalDateTime;
import java.util.List;

public interface IService<T,TYPE> {
    T read(long id);
    List<T> get();
    T create(TYPE item);
    T update(long id, LocalDateTime dtUpdate, TYPE item);
    void delete(long id, LocalDateTime dtUpdate);
}
