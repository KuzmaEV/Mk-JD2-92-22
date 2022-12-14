package by.example.demo.pizzeria.services;

import by.example.demo.pizzeria.dao.api.IMenuRowDao;
import by.example.demo.pizzeria.dao.entity.MenuRow;
import by.example.demo.pizzeria.dao.entity.PizzaInfo;
import by.example.demo.pizzeria.services.api.IMenuRowService;
import by.example.demo.pizzeria.services.api.IPizzaInfoService;
import by.example.demo.pizzeria.services.dto.MenuRowDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
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

        return dao.findById(id).orElseThrow();
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

        MenuRow menuRow = dao.findById(id).orElseThrow();

        PizzaInfo pizzaInfo = servicePizzaInfo.read(item.getInfo());

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
        MenuRow read = dao.findById(id).orElseThrow();

        if (!read.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Не удалось удалить, ктото успел отредактировать!");
        }
        dao.deleteById(id);
    }

}
