package by.example.demo.pizzeria.services;

import by.example.demo.pizzeria.dao.api.IStageDao;
import by.example.demo.pizzeria.dao.entity.Stage;
import by.example.demo.pizzeria.services.api.IStageService;
import by.example.demo.pizzeria.services.dto.StageDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class StageService implements IStageService {

    private final IStageDao dao;

    public StageService(IStageDao dao) {
        this.dao = dao;
    }

    @Override
    public Stage read(long id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<Stage> get() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public Stage create(StageDTO item) {

        LocalTime now = LocalTime.now();
        Stage stage = new Stage(item.getDescription(), now, item.getOrderStatus());

        return dao.save(stage);
    }


    @Override
    @Transactional
    public Stage update(long id, LocalDateTime dtUpdate, StageDTO item) {


        return null;
    }

    @Override
    @Transactional
    public void delete(long id, LocalDateTime dtUpdate) {

    }

    @Override
    @Transactional
    public void delete(long id) {
        dao.deleteById(id);
    }
}
