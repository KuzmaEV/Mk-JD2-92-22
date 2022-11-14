package by.it_academy.jd2.Mk_JD2_92_22.pizza.services;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.DtoMenuRowService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.DtoMenuRowServlet;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.sindleton.PizzaInfoDaoSingleton;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IMenuRowDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IPizzaInfoDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IMenuRowService;

import java.time.LocalDateTime;
import java.util.List;

public class MenuRowService implements IMenuRowService {
    private final IMenuRowDao dao;
    private final IPizzaInfoDao daoPizzaInfo ;

    public MenuRowService(IMenuRowDao dao) {
        this.dao = dao;
        this.daoPizzaInfo = PizzaInfoDaoSingleton.getInstance();
    }


    @Override
    public IMenuRow read(long id) {

        IMenuRow menuRow = dao.read(id);
        if (menuRow == null){
            throw new IllegalArgumentException("Пицца не найдена!");
        }
        return menuRow;
    }

    @Override
    public List<IMenuRow> get() {
        return dao.get();
    }

    @Override
    public IMenuRow create(DtoMenuRowServlet item) {

        if (daoPizzaInfo.read(item.getInfo()) == null){
            throw new IllegalArgumentException("Такой пиццы не существует");
        }

        return dao.create(mapper(item));
    }

    @Override
    public IMenuRow update(long id, LocalDateTime dtUpdate, DtoMenuRowServlet item) {

        IMenuRow menuRow = dao.read(id);

        if (menuRow == null){
            throw new IllegalArgumentException("Пункт меню не найден!");
        }

        if (item.getInfo() == 0){           //Если отсуствует Пицца в ДТО, добавляется старая
            item.setInfo(menuRow.getInfo().getId());
        }
        if (item.getPrice() == 0){          //Если отсуствует Цена в ДТО, добавляется старая
            item.setPrice(menuRow.getPrice());
        }
        if (item.getMenu() == 0){           //Если отсуствует Меню в ДТО, добавляется старая
            item.setMenu(menuRow.getMenu());
        }

        if (!menuRow.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Не удалось обновить, кто-то успел отредактировать!");
        }


        return dao.update(id, dtUpdate, mapper(item));
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {
        IMenuRow read = dao.read(id);

        if (read == null){
            throw new IllegalArgumentException("Пункт меню не найден!");
        }
        if (!read.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Не удалось удалить, ктото успел отредактировать!");
        }
        dao.delete(id,dtUpdate);
    }

    public static DtoMenuRowService mapper(DtoMenuRowServlet dto){
        return new DtoMenuRowService(
                LocalDateTime.now(),
                dto.getInfo(),
                dto.getPrice(),
                dto.getMenu());
    }
}
