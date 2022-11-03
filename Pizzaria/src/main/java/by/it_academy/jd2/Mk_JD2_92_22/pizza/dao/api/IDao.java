package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api;

import java.time.LocalDateTime;
import java.util.List;

public interface IDao<T> {
    T read(long id);
    List<T> get();
    T create(T item);
    T update(long id, LocalDateTime dtUpdate, T item);
    void delete(long id, LocalDateTime dtUpdate);
}
