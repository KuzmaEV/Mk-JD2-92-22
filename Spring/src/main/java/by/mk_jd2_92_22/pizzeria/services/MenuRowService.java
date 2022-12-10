package by.mk_jd2_92_22.pizzeria.services;

import by.mk_jd2_92_22.pizzeria.dao.api.IMenuRowDao;
import by.mk_jd2_92_22.pizzeria.dao.entity.MenuRow;
import by.mk_jd2_92_22.pizzeria.dao.entity.PizzaInfo;
import by.mk_jd2_92_22.pizzeria.services.api.IMenuRowService;
import by.mk_jd2_92_22.pizzeria.services.api.IPizzaInfoService;
import by.mk_jd2_92_22.pizzeria.services.dto.MenuRowDTO;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Transactional(readOnly = true)
public class MenuRowService implements IMenuRowService {
    private final IMenuRowDao dao;
    private final IPizzaInfoService servicePizzaInfo;

    public MenuRowService(IMenuRowDao dao, IPizzaInfoService servicePizzaInfo) {
        this.dao = dao;
        this.servicePizzaInfo = servicePizzaInfo;
    }


    @Override
    public MenuRow read(long id) {

        MenuRow menuRow = dao.getReferenceById(id);
        if (menuRow == null){
            throw new IllegalArgumentException("Пункт меню не найден!");
        }
        return menuRow;
    }

    @Override
    public List<MenuRow> get() {
        return dao.findAll();
    }


    @Override
    @Transactional
    public MenuRow create(MenuRowDTO item) {

        PizzaInfo pizzaInfo = servicePizzaInfo.read(item.getInfo());

        if (pizzaInfo == null){
            throw new IllegalArgumentException("Такой пиццы не существует");
        }

        MenuRow menuRow = new MenuRow(
                LocalDateTime.now(),
                LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS),
                pizzaInfo,
                item.getPrice(),
                item.getMenu());

        return dao.save(menuRow);
    }

    @Override
    @Transactional
    public MenuRow update(long id, LocalDateTime dtUpdate, MenuRowDTO item) {

        MenuRow menuRow = dao.getReferenceById(id);

        PizzaInfo pizzaInfo = servicePizzaInfo.read(item.getInfo());

        if (menuRow == null){
            throw new IllegalArgumentException("Пункт меню не найден!");
        }


        if (item.getInfo() != 0){           //Если отсуствует Пицца в ДТО, остается старая
            menuRow.setInfo(pizzaInfo);
        }
        if (item.getPrice() != 0){          //Если отсуствует Цена в ДТО, остается старая
            menuRow.setPrice(item.getPrice());
        }
        if (item.getMenu() != 0){           //Если отсуствует Меню в ДТО, остается старая
            menuRow.setMenu(item.getMenu());
        }

        if (!menuRow.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Не удалось обновить, кто-то успел отредактировать!");
        }
        menuRow.setDtUpdate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS)); //Добавил время обнавления


        return dao.save(menuRow);
    }

    @Override
    @Transactional
    public void delete(long id, LocalDateTime dtUpdate) {
        MenuRow read = dao.getReferenceById(id);

        if (read == null){
            throw new IllegalArgumentException("Пункт меню не найден!");
        }
        if (!read.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Не удалось удалить, ктото успел отредактировать!");
        }
        dao.deleteById(id);
    }

}
