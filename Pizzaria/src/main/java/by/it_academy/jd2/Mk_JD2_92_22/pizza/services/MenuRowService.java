package by.it_academy.jd2.Mk_JD2_92_22.pizza.services;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.DtoMenuRowService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.DtoMenuRowServlet;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IMenuRowDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IMenuRowService;

import java.time.LocalDateTime;
import java.util.List;

public class MenuRowService implements IMenuRowService {
    private final IMenuRowDao dao;

    public MenuRowService(IMenuRowDao dao) {
        this.dao = dao;
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

        return dao.create(mapper(item));
    }

    @Override
    public IMenuRow update(long id, LocalDateTime dtUpdate, DtoMenuRowServlet item) {

        IMenuRow read = dao.read(id);

        if (read == null){
            throw new IllegalArgumentException("Пункт меню не найден!");
        }
        if (!read.getDtUpdate().isEqual(dtUpdate)){
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
