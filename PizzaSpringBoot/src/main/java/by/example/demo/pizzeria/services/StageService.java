package by.example.demo.pizzeria.services;

import by.example.demo.pizzeria.dao.api.IStageDao;
import by.example.demo.pizzeria.dao.entity.Stage;
import by.example.demo.pizzeria.services.api.IStageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
    public Stage create(String item) {

        LocalDateTime now = LocalDateTime.now();
        Stage stage = new Stage(
                now,
                now,
                item);

        return dao.save(stage);
    }


    @Override
    @Transactional
    public Stage update(long id, LocalDateTime dtUpdate, String item) {

        Stage stage = dao.findById(id).orElseThrow();


        if (stage.getDtUpdate().isEqual(dtUpdate)){
            stage.setDtUpdate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));
        } else {
            throw new IllegalArgumentException("Пицца кем-то отредактирована");
        }

        return dao.save(stage);
    }

    @Override
    @Transactional
    public void delete(long id, LocalDateTime dtUpdate) {

        Stage stage = dao.findById(id).orElseThrow();


        if (stage.getDtUpdate().isEqual(dtUpdate)){
            stage.setDtUpdate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));
        } else {
            throw new IllegalArgumentException("Пицца кем-то отредактирована");
        }
        dao.deleteById(id);
    }
}
