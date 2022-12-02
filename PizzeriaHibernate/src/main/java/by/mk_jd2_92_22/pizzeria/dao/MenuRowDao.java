package by.mk_jd2_92_22.pizzeria.dao;

import by.mk_jd2_92_22.pizzeria.dao.api.IMenuRowDao;
import by.mk_jd2_92_22.pizzeria.dao.entity.MenuRow;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.IMenuRow;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

public class MenuRowDao implements IMenuRowDao {

    private final EntityManager entityManager;

    public MenuRowDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public IMenuRow read(long id) {

//        String selectQuery = "from MenuRow" +
//                "where id = :id";

        entityManager.getTransaction().begin();

//        Query query = entityManager.createQuery(selectQuery);
//        query.setParameter("id", id);
//        MenuRow result = query.unwrap(MenuRow.class);

        MenuRow menuRow = entityManager.find(MenuRow.class, id);

        entityManager.getTransaction().commit();

        return menuRow;
    }

    @Override
    public List<IMenuRow> get() {

        TypedQuery<IMenuRow> menuRows = entityManager.createQuery("from MenuRow m", IMenuRow.class);

         return menuRows.getResultList();


//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<IMenuRow> criteriaQuery = criteriaBuilder.createQuery(IMenuRow.class);
//        Root<MenuRow> root = criteriaQuery.from(MenuRow.class);
//        criteriaQuery.select(root);
//
//        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public IMenuRow create(IMenuRow item) {

        entityManager.getTransaction().begin();
        entityManager.persist(item);
        entityManager.getTransaction().commit();

//        String insertQuery = "INSERT INTO MenuRow (dt_create, dt_update, info, price, menu)" +
//                " VALUES(:dtCreate, :dtUpdate, :info, :price, :menu)";
//
//        Query query = entityManager.createQuery(insertQuery);
//
//        query.setParameter("dtCreate", item.getDtCreate());
//        query.setParameter("dtUpdate", item.getDtUpdate());
//        query.setParameter("info", item.getInfo());
//        query.setParameter("price", item.getPrice());
//        query.setParameter("menu", item.getMenu());
//
//        int createdRows = query.executeUpdate();
            if (item == null){
                throw new IllegalArgumentException("Не удалось создать новый пункт меню!");
            }

        return item;
    }

    @Override
    public IMenuRow update(long id, LocalDateTime dtUpdate, IMenuRow item) {

        String updateQuery = "UPDATE MenuRow m " +
                "SET m.dtUpdate = :ItemDtUpdate, m.info = :info, m.price = :price, m.menu = :menu " +
                "WHERE m.id = :id AND m.dtUpdate = :dtUpdate";

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(updateQuery);
        query.setParameter("ItemDtUpdate", item.getDtUpdate());
        query.setParameter("info", item.getInfo());
        query.setParameter("price", item.getPrice());
        query.setParameter("menu", item.getMenu());

        query.setParameter("id", id);
        query.setParameter("dtUpdate", dtUpdate);

       /* int updatedRows = */query.executeUpdate();
        entityManager.getTransaction().commit();

//        if (updatedRows != 1){
//            if (updatedRows == 0){
//                throw new RuntimeException("Не удалось обнавить пункт меню!");
//            } else {
//                throw new RuntimeException("Обнавило несколько меню пунктов!");
//            }
//        }


        return item;
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

        String deleteQuery = "delete MenuRow m " +
                "where m.id = :id and m.dtUpdate = :dtUpdate";

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(deleteQuery);

        query.setParameter("id", id);
        query.setParameter("dtUpdate", dtUpdate);

        int remoteRows = query.executeUpdate();
        entityManager.getTransaction().commit();

        if (remoteRows != 1){
            if (remoteRows == 0){
                throw new IllegalArgumentException("Не удалось удаить пункт меню!");
            }
            if (remoteRows > 1){
                throw new IllegalArgumentException("Удалило более одного пункта меню!");
            }
        }


    }

}
