package by.mk_jd2_92_22.pizzeria.dao;

import by.mk_jd2_92_22.pizzeria.dao.api.IMenuDao;
import by.mk_jd2_92_22.pizzeria.dao.entity.Menu;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.IMenu;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;


public class MenuDao implements IMenuDao {

    private final EntityManager entityManager;

    public MenuDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public IMenu read(long id) {

        //    throw new RuntimeException("При запросе Меню возникла ошибка");
        return entityManager.find(Menu.class, id);

    }

    @Override
    public List<IMenu> get() {

   //         throw new RuntimeException("При запросе данных возникла ошибка" );

        TypedQuery<IMenu> menu = entityManager.createQuery("from Menu m", IMenu.class);
        return menu.getResultList();

    }

    @Override
    public IMenu create(IMenu item) {

        entityManager.getTransaction().begin();
        entityManager.persist(item);
        entityManager.getTransaction().commit();
       //     throw new RuntimeException("При создании Меню возникла ошибка" );

        return item;
    }

    @Override
    public IMenu update(long id, LocalDateTime dtUpdate, IMenu item) {




        String updateQuery = "UPDATE Menu m " +
                "SET m.dtUpdate = :ItemDtUpdate, m.name = :name, m.enabled = :enable " +
                "WHERE m.id = :id AND m.dtUpdate = :dtUpdate";

//                "UPDATE Menu menu " +
//                "SET menu.dtUpdate = :ItemDtUpdate, menu.name = :name, menu.enable = :enable " +
//                "WHERE menu.id = :id AND menu.dtUpdate = :dtUpdate";

        entityManager.getTransaction().begin();
//        IMenu merge = entityManager.merge(item);

        Query query = entityManager.createQuery(updateQuery);
        query.setParameter("ItemDtUpdate", item.getDtUpdate());
        query.setParameter("name", item.getName());
        query.setParameter("enable", item.isEnabled());

        query.setParameter("id", id);
        query.setParameter("dtUpdate", dtUpdate);

        query.executeUpdate();
//
//            if (updatedRows != 1){
//                if (updatedRows == 0){
//                    throw new RuntimeException("Не удалось обновить запись!");
//                } else {
//                    throw new RuntimeException("Обновило несколько записей!");
//                }
//            }

            entityManager.getTransaction().commit();

        //    throw new RuntimeException("При обнавлении данных возникла ошибка");
        return item;
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

        String deleteMenuRowQuery = "delete MenuRow row " +
                "where row.menu = :id";
        String deleteQuery = "delete Menu m " +
                "where m.id = :id and m.dtUpdate = :dtUpdate";

        entityManager.getTransaction().begin();

        Query queryMenuRow = entityManager.createQuery(deleteMenuRowQuery);
        queryMenuRow.setParameter("id", id);
        queryMenuRow.executeUpdate();

        Query query = entityManager.createQuery(deleteQuery);
        query.setParameter("id", id);
        query.setParameter("dtUpdate", dtUpdate);

        int countDeletedMenu = query.executeUpdate();

        if (countDeletedMenu != 1){
            if (countDeletedMenu == 0){
                throw new IllegalArgumentException("Не удалось удалить запись!");
            } else {
                throw new IllegalArgumentException("Удалило больше одной записи!");
            }
        }

        entityManager.getTransaction().commit();

    }

}


