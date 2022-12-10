package by.mk_jd2_92_22.pizzeria.services;

import by.mk_jd2_92_22.pizzeria.dao.api.IPizzaInfoDao;
import by.mk_jd2_92_22.pizzeria.dao.entity.PizzaInfo;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.IPizzaInfo;
import by.mk_jd2_92_22.pizzeria.services.api.IPizzaInfoService;
import by.mk_jd2_92_22.pizzeria.services.dto.PizzaInfoDTO;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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

        IPizzaInfo pizzaInfo = new PizzaInfo(
                LocalDateTime.now(),
                LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS),
                item.getName(),
                item.getDescription(),
                item.getSize()
        );

        return dao.create(pizzaInfo);
    }

    @Override
    public IPizzaInfo update(long id, LocalDateTime dtUpdate/*дата последнено изменения*/,
                             PizzaInfoDTO item/* dto БЕЗ ид и дт, только параметры для изменения*/) {
        IPizzaInfo pizzaInfo = dao.read(id);


        if (pizzaInfo == null){
            throw new IllegalArgumentException("Пицца не найдена");
        }

        if (item.getName() != null){
            pizzaInfo.setName(item.getName());
        }
        if (item.getDescription() != null){
            pizzaInfo.setDescription(item.getDescription());
        }
        if (item.getSize() != 0){
            pizzaInfo.setSize(item.getSize());
        }
        if (pizzaInfo.getDtUpdate().isEqual(dtUpdate)){
           pizzaInfo.setDtUpdate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));
        } else {
            throw new IllegalArgumentException("Пицца кем-то отредактирована");
        }

        return dao.update(id, dtUpdate, pizzaInfo);
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
