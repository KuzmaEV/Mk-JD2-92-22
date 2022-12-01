package by.mk_jd2_92_22.pizzeria.dao;

import by.mk_jd2_92_22.pizzeria.dao.api.IMenuRowDao;
import by.mk_jd2_92_22.pizzeria.dao.entity.MenuRow;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.IMenuRow;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

//        TypedQuery<MenuRow> menuRows = entityManager.createQuery("from MenuRow m", MenuRow.class);
//        List<IMenuRow> resultList = menuRows.getResultList();

        // return (List<IMenuRow>) entityManager.createQuery("from MenuRow m").getResultList();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<IMenuRow> criteriaQuery = criteriaBuilder.createQuery(IMenuRow.class);
        Root<MenuRow> root = criteriaQuery.from(MenuRow.class);
        criteriaQuery.select(root);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public IMenuRow create(IMenuRow item) {

//        entityManager.persist(item);


        String insertQuery = "INSERT INTO MenuRow (dt_create, dt_update, info, price, menu)" +
                " VALUES(:dtCreate, :dtUpdate, :info, :price, :menu)";

        Query query = entityManager.createQuery(insertQuery);

        query.setParameter("dtCreate", item.getDtCreate());
        query.setParameter("dtUpdate", item.getDtUpdate());
        query.setParameter("info", item.getInfo());
        query.setParameter("price", item.getPrice());
        query.setParameter("menu", item.getMenu());

        int createdRows = query.executeUpdate();
            if (createdRows == 0){
                throw new IllegalArgumentException("Не удалось создать новый пункт меню!");
            }

        return item;
    }

    @Override
    public IMenuRow update(long id, LocalDateTime dtUpdate, IMenuRow item) {

        String updateQuery = "UPDATE MenuRow " +
                "set dt_update = :ItemDtUpdate, info = :info, price = :price, menu = :menu" +
                "WHERE id = :id AND dt_update = :dtUpdate";

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(updateQuery);
        query.setParameter("ItemDtUpdate", item.getDtUpdate());
        query.setParameter("info", item.getInfo());
        query.setParameter("price", item.getPrice());
        query.setParameter("menu", item.getMenu());

        query.setParameter("id", id);
        query.setParameter("dtUpdate", dtUpdate);

        int updatedRows = query.executeUpdate();

        if (updatedRows != 1){
            if (updatedRows == 0){
                throw new RuntimeException("Не удалось обнавить пункт меню!");
            } else {
                throw new RuntimeException("Обнавило несколько меню пунктов!");
            }
        }
        entityManager.getTransaction().commit();


        return read(id);
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

        String deleteQuery = "delete MenuRow m " +
                "where m.id = :id and m.dt_update = :dtUpdate";

        Query query = entityManager.createQuery(deleteQuery);

        query.setParameter("id", id);
        query.setParameter("dtUpdate", dtUpdate);

        int remoteRows = query.executeUpdate();

        if (remoteRows == 0){
            throw new IllegalArgumentException("Не удалось удаить пункт меню!");
        }


    }

}
