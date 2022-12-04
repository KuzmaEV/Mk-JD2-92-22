package by.mk_jd2_92_22.pizzeria.services;

import by.mk_jd2_92_22.pizzeria.dao.api.IMenuDao;
import by.mk_jd2_92_22.pizzeria.dao.entity.Menu;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.IMenu;
import by.mk_jd2_92_22.pizzeria.services.api.IMenuService;
import by.mk_jd2_92_22.pizzeria.services.dto.MenuDTO;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
    public IMenu create(MenuDTO item) {


        IMenu menu = new Menu(
                LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS),
                LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS),
                item.getName(),
                item.isEnabled()
        );
        return dao.create(menu);
    }

    @Override
    public IMenu update(long id, LocalDateTime dtUpdate, MenuDTO item) {

        IMenu menu = dao.read(id);

        if (menu == null){
            throw new IllegalArgumentException("Меню не найдено!");
        }
        if (!menu.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Не удалось обнавить данные, кто-то отредактировал раньше!");
        }

        menu.setDtUpdate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));

        if (item.getName() != null){
            menu.setName(item.getName());
        }

        menu.setEnabled(item.isEnabled());

        return dao.update(id, dtUpdate, menu);
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
