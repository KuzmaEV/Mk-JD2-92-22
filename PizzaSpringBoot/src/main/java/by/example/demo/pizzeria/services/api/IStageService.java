package by.example.demo.pizzeria.services.api;

import by.example.demo.pizzeria.dao.entity.Stage;
import by.example.demo.pizzeria.services.dto.StageDTO;

public interface IStageService extends IService<Stage, StageDTO> {
    void delete(long id);
}
