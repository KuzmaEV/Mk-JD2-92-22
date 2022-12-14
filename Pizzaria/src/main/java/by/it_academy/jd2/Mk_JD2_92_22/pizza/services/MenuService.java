package by.it_academy.jd2.Mk_JD2_92_22.pizza.services;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IMenu;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.dto.DtoMenuService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.dto.DtoMenuServlet;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IMenuDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IMenuService;

import java.time.LocalDateTime;
import java.util.List;

public class MenuService implements IMenuService {

    private final IMenuDao dao;

    public MenuService(IMenuDao dao) {
        this.dao = dao;
    }

    @Override
    public IMenu read(long id) {
        IMenu menu = dao.read(id);
        if (menu == null){
            throw new IllegalArgumentException("Меню не найдено");
        }
        return menu;
    }

    @Override
    public List<IMenu> get() {
        return dao.get();
    }

    @Override
    public IMenu create(DtoMenuServlet item) {
        return dao.create(new DtoMenuService(LocalDateTime.now(),
                item.getName(),
                item.isEnabled()));
    }

    @Override
    public IMenu update(long id, LocalDateTime dtUpdate, DtoMenuServlet item) {

        IMenu menu = dao.read(id);

        if (menu == null){
            throw new IllegalArgumentException("Меню не найдено!");
        }
        if (!menu.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Не удалось обнавить данные, кто-то отредактировал раньше!");
        }

        return dao.update(id, dtUpdate, new DtoMenuService(LocalDateTime.now(),
                item.getName(),
                item.isEnabled()));
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {
        IMenu menu = dao.read(id);

        if (menu == null){
            throw new IllegalArgumentException("Меню не найдено!");
        }
        if (!menu.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Не удалось удалить данные, кто-то отредактировал раньше!");
        }

        dao.delete(id, dtUpdate);

    }
}
