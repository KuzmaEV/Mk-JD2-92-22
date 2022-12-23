package by.mk_jd2_92_22.journalReport.service.api;

import java.util.List;
import java.util.UUID;

public interface IService <DTO, ENTITY>{
    void create(DTO dto);
    ENTITY get(UUID uuid);
    List<ENTITY>getAll();

}
