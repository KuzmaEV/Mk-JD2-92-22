package by.mk_jd2_92_22.pizzeria.dao;

import by.mk_jd2_92_22.pizzeria.dao.api.IMenuRowDao;
import by.mk_jd2_92_22.pizzeria.dao.entity.MenuRow;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.IMenuRow;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class MenuRowDao implements IMenuRowDao {

    private final EntityManager entityManager;

    public MenuRowDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public IMenuRow read(long id) {

        entityManager.getTransaction().begin();
        MenuRow menuRow = entityManager.find(MenuRow.class, id);
        entityManager.getTransaction().commit();

        return menuRow;
    }

    @Override
    public List<IMenuRow> get() {
        return null;
    }

    @Override
    public IMenuRow create(IMenuRow item) {


        return null;
    }

    @Override
    public IMenuRow update(long id, LocalDateTime dtUpdate, IMenuRow item) {

        return null;
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {


    }

}
