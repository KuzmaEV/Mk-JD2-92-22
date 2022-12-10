package by.mk_jd2_92_22.pizzeria.services;

import by.mk_jd2_92_22.pizzeria.dao.api.IPizzaInfoDao;
import by.mk_jd2_92_22.pizzeria.dao.entity.PizzaInfo;
import by.mk_jd2_92_22.pizzeria.services.api.IPizzaInfoService;
import by.mk_jd2_92_22.pizzeria.services.dto.PizzaInfoDTO;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Transactional(readOnly = true)
public class PizzaInfoService implements IPizzaInfoService {

    private final IPizzaInfoDao dao;

    public PizzaInfoService(IPizzaInfoDao dao) {
        this.dao = dao;
    }

    @Override
    public PizzaInfo read(long id) {

        return dao.getReferenceById(id);
    }

    @Override
    public List<PizzaInfo> get() {

        return dao.findAll();
    }

    @Override
    @Transactional
    public PizzaInfo create(PizzaInfoDTO item) {

        PizzaInfo pizzaInfo = new PizzaInfo(
                LocalDateTime.now(),
                LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS),
                item.getName(),
                item.getDescription(),
                item.getSize()
        );

        return dao.save(pizzaInfo);
    }

    @Override
    @Transactional
    public PizzaInfo update(long id, LocalDateTime dtUpdate/*дата последнено изменения*/,
                             PizzaInfoDTO item/* dto БЕЗ ид и дт, только параметры для изменения*/) {
        PizzaInfo pizzaInfo = dao.getReferenceById(id);


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

        return dao.save(pizzaInfo);
    }

    @Override
    @Transactional
    public void delete(long id, LocalDateTime dtUpdate) {

        PizzaInfo read = dao.getReferenceById(id);

        if (read == null){
            throw new IllegalArgumentException("Пицца не найдена");
        }
        if (!read.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Не удалось удалить, пицца было кем-то отредактирована");
        }
        dao.deleteById(id);
    }


}
