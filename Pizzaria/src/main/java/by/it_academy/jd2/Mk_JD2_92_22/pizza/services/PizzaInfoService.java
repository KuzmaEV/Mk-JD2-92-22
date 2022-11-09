package by.it_academy.jd2.Mk_JD2_92_22.pizza.services;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.DtoPizzaInfoService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.DtoPizzaInfoServlet;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IPizzaInfoDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.PizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IPizzaInfoService;

import java.time.LocalDateTime;
import java.util.List;

public class PizzaInfoService implements IPizzaInfoService {

    private final IPizzaInfoDao dao;

    public PizzaInfoService(IPizzaInfoDao dao) {
        this.dao = dao;
    }

    @Override
    public IPizzaInfo read(long id) {

        return dao.read(id);
    }

    @Override
    public List<IPizzaInfo> get() {

        return dao.get();
    }

    @Override
    public IPizzaInfo create(DtoPizzaInfoServlet item) {

        return dao.create(new DtoPizzaInfoService(
                LocalDateTime.now(),
                item.getName(),
                item.getDescription(),
                item.getSize()));
    }

    @Override
    public IPizzaInfo update(long id, LocalDateTime dtUpdate/*дата последнено изменения*/,
                             DtoPizzaInfoServlet item/* dto БЕЗ ид и дт, только параметры для изменения*/) {
        IPizzaInfo read = dao.read(id);

        if (read == null){
            throw new IllegalArgumentException("Пицца не найдена");
        }
        if (!read.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Пицца кем-то отредактирована");
        }

        DtoPizzaInfoService updatePizza = new DtoPizzaInfoService(
                LocalDateTime.now(),
                item.getName(),
                item.getDescription(),
                item.getSize());

        return dao.update(id, dtUpdate, updatePizza);
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

        IPizzaInfo read = dao.read(id);

        if (read == null){
            throw new IllegalArgumentException("Пицца не найдена");
        }
        if (!read.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Не удалось удалить, пицца было кем-то отредактирована");
        }
        dao.delete(id, dtUpdate);
    }
}
