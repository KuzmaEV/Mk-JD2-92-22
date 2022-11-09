package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api;

import java.time.LocalDateTime;
import java.util.List;

public interface IDao<T, TYPE> {
    T read(long id);
    List<T> get();
    T create(TYPE item);
    T update(long id, LocalDateTime dtUpdate, TYPE item);
    void delete(long id, LocalDateTime dtUpdate);
}
