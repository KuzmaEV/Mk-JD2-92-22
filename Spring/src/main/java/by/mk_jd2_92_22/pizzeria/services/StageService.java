package by.mk_jd2_92_22.pizzeria.services;

import by.mk_jd2_92_22.pizzeria.dao.api.IStageDao;
import by.mk_jd2_92_22.pizzeria.dao.entity.Stage;
import by.mk_jd2_92_22.pizzeria.services.api.IStageService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

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
    public Stage create(String item) {

        LocalDateTime now = LocalDateTime.now();
        Stage stage = new Stage(
                now,
                now,
                item);

        return dao.save(stage);
    }

    @Override
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
