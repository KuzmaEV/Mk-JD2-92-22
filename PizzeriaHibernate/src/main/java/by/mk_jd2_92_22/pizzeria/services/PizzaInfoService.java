package by.mk_jd2_92_22.pizzeria.services;

import by.mk_jd2_92_22.pizzeria.core.entity.api.IPizzaInfo;
import by.mk_jd2_92_22.pizzeria.dao.api.IPizzaInfoDao;
import by.mk_jd2_92_22.pizzeria.services.api.IPizzaInfoService;
import by.mk_jd2_92_22.pizzeria.services.dto.PizzaInfoDTO;

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
    public IPizzaInfo create(PizzaInfoDTO item) {

        item.setDtUpdate(LocalDateTime.now());
        return dao.create(item);
    }

    @Override
    public IPizzaInfo update(long id, LocalDateTime dtUpdate/*дата последнено изменения*/,
                             PizzaInfoDTO item/* dto БЕЗ ид и дт, только параметры для изменения*/) {
        IPizzaInfo read = dao.read(id);

        if (read == null){
            throw new IllegalArgumentException("Пицца не найдена");
        }
        if (!read.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Пицца кем-то отредактирована");
        }

        item.setDtUpdate(LocalDateTime.now());
        return dao.update(id, dtUpdate, item);
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
