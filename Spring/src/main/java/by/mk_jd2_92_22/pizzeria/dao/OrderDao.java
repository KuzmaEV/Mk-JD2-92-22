package by.mk_jd2_92_22.pizzeria.dao;

import by.mk_jd2_92_22.pizzeria.dao.api.IOrderDao;
import by.mk_jd2_92_22.pizzeria.dao.entity.Order;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.IOrder;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.ISelectedItem;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;


public class OrderDao implements IOrderDao {

    private final EntityManager entityManager;

    public OrderDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public IOrder read(long id) {

//            throw new RuntimeException("Не удалось получить заказ! " );
        return entityManager.find(Order.class, id);
    }

    @Override
    public List<IOrder> get() {

//            throw new RuntimeException("Не удалось получить спимок заказов! ");

        TypedQuery<IOrder> orders = entityManager.createQuery("from Order o", IOrder.class);

        return orders.getResultList();
    }

    @Override
    public IOrder create(IOrder item) {

        entityManager.getTransaction().begin();
//        try {

            entityManager.persist(item);

            List<ISelectedItem> selectedItem = item.getSelectedItem();
            for (ISelectedItem row : selectedItem) {
                row.setOrder(item.getId());
                entityManager.persist(row);
            }
//        } catch (PersistenceException e) {
//            throw new
//        }

        entityManager.getTransaction().commit();

//            throw new RuntimeException("Не получилось сдалоть заказ! " + e.getMessage());

        return item;
    }

    @Override
    public IOrder update(long id, LocalDateTime dtUpdate, IOrder item) {

//        String updateQuery = "UPDATE Order o " +
//                "SET o.dtUpdate = :ItemDtUpdate " +
//                "WHERE o.id = :id AND o.dtUpdate = :dtUpdate";

        String deleteSelectedItemQuery = "delete SelectedItem s " +
                "where s.order = :id ";

        entityManager.getTransaction().begin();

        Query querySelectedItem = entityManager.createQuery(deleteSelectedItemQuery);
        querySelectedItem.setParameter("id", id);
        querySelectedItem.executeUpdate();

        List<ISelectedItem> selectedItem = item.getSelectedItem();
        for (ISelectedItem row : selectedItem) {
            row.setOrder(id);
            entityManager.persist(row);
        }

//        Query query = entityManager.createQuery(updateQuery);
//
//        query.setParameter("id", id);
//        query.setParameter("dtUpdate", dtUpdate);
//
//        query.setParameter("ItemDtUpdate", item.getDtUpdate());
//        int countUpdateRows = query.executeUpdate();

//            if (countUpdateRows != 1){
//                if (countUpdateRows == 0){
//                    throw new RuntimeException("Не удалось обновить запись!");
//                } else {
//                    throw new RuntimeException("Обновило несколько записей!");
//                }
//            }

        entityManager.getTransaction().commit();

        return item;
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

        String deleteQuery = "delete Order o " +
                "where o.id = :id and o.dtUpdate = :dtUpdate";

        String deleteSelectedItemQuery = "delete SelectedItem s " +
                "where s.order = :id ";

        entityManager.getTransaction().begin();

        Query querySelectedItem = entityManager.createQuery(deleteSelectedItemQuery);
        querySelectedItem.setParameter("id", id);
        querySelectedItem.executeUpdate();

//        IOrder order = read(id);
//        for (ISelectedItem row : order.getSelectedItem()) {
//            entityManager.remove(row);
//        }

        Query query = entityManager.createQuery(deleteQuery);
        query.setParameter("id", id);
        query.setParameter("dtUpdate", dtUpdate);

        int countDeletedRowsOrder = query.executeUpdate();

        if (countDeletedRowsOrder != 1){
                if (countDeletedRowsOrder == 0){
                    throw new IllegalArgumentException("Не удалось удалить!");
                } else {
                    throw new IllegalArgumentException("Ошибка. Удалило несколько заказов!");
                }
            }

        entityManager.getTransaction().commit();

//            throw new RuntimeException("Ну удалось удалить заказ! " + e.getMessage());
    }
}
