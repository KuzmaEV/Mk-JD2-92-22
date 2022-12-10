package by.mk_jd2_92_22.pizzeria.services;

import by.mk_jd2_92_22.pizzeria.dao.api.IMenuDao;
import by.mk_jd2_92_22.pizzeria.dao.entity.Menu;
import by.mk_jd2_92_22.pizzeria.services.api.IMenuService;
import by.mk_jd2_92_22.pizzeria.services.dto.MenuDTO;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Transactional(readOnly = true)
public class MenuService implements IMenuService {

    private final IMenuDao dao;

    public MenuService(IMenuDao dao) {
        this.dao = dao;
    }

    @Override
    public Menu read(long id) {

        return dao.getReferenceById(id);
    }

    @Override
    public List<Menu> get() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public Menu create(MenuDTO item) {


        Menu menu = new Menu(
                LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS),
                LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS),
                item.getName(),
                item.isEnabled()
        );
        return dao.save(menu);
    }

    @Override
    @Transactional
    public Menu update(long id, LocalDateTime dtUpdate, MenuDTO item) {

        Menu menu = dao.getReferenceById(id);

//        if (menu == null){
//            throw new IllegalArgumentException("Меню не найдено!");
//        }
        if (!menu.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Не удалось обнавить данные, кто-то отредактировал раньше!");
        }

        menu.setDtUpdate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));

        if (item.getName() != null){
            menu.setName(item.getName());
        }

        menu.setEnabled(item.isEnabled());

        return dao.save(menu);
    }

    @Override
    @Transactional
    public void delete(long id, LocalDateTime dtUpdate) {
        Menu menu = dao.getReferenceById(id);

//        if (menu == null){
//            throw new IllegalArgumentException("Меню не найдено!");
//        }
        if (!menu.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Не удалось удалить данные, кто-то отредактировал раньше!");
        }

        dao.deleteById(id);

    }
}
