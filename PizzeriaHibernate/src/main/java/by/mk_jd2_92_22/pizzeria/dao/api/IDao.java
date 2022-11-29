package by.mk_jd2_92_22.pizzeria.dao.api;

import java.time.LocalDateTime;
import java.util.List;

public interface IDao<ENTITY, DTO> {
    ENTITY read(long id);
    List<ENTITY> get();
    ENTITY create(DTO item);
    ENTITY update(long id, LocalDateTime dtUpdate, DTO item);
    void delete(long id, LocalDateTime dtUpdate);
}
