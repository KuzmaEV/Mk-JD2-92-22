package by.it_academy.jd2.Mk_JD2_92_22.pizza.services;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IStage;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.dto.StageDTO;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IStageDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IStageService;

import java.time.LocalDateTime;
import java.util.List;

public class StageService implements IStageService {

    private final IStageDao dao;

    public StageService(IStageDao dao) {
        this.dao = dao;
    }

    @Override
    public IStage read(long id) {
        return dao.read(id);
    }

    @Override
    public List<IStage> get() {
        return dao.get();
    }

    @Override
    public IStage create(StageDTO item) {

        item.setDtUpdate(LocalDateTime.now());

        return dao.create(item);
    }

    @Override
    public IStage update(long id, LocalDateTime dtUpdate, StageDTO item) {
        return null;
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

    }
}
