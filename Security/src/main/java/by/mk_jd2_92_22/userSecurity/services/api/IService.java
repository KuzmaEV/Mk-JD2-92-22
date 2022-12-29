package by.mk_jd2_92_22.userSecurity.services.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface IService<ENTITY, DTO> {
    ENTITY create(DTO item);
    ENTITY get(UUID uuid);
    List<ENTITY> getAll();
    ENTITY update(UUID uuid, LocalDateTime dtUpdate, DTO item);


}
