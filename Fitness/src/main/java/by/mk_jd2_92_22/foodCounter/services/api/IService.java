package by.mk_jd2_92_22.foodCounter.services.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface IService<ENTITY, DTO> {
    ENTITY create(DTO item);
    ENTITY read(UUID id);
    List<ENTITY> get();
    ENTITY update(UUID id, LocalDateTime dtUpdate, DTO item);
    void delete(UUID id, LocalDateTime dtUpdate);
}
