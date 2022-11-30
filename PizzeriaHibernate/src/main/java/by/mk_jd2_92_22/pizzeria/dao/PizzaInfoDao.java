package by.mk_jd2_92_22.pizzeria.dao;


import by.mk_jd2_92_22.pizzeria.core.entity.PizzaInfo;
import by.mk_jd2_92_22.pizzeria.core.entity.api.IPizzaInfo;
import by.mk_jd2_92_22.pizzeria.dao.api.IPizzaInfoDao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.time.LocalDateTime;

import java.util.List;

public class PizzaInfoDao implements IPizzaInfoDao {

    private final EntityManager entityManager;

    public PizzaInfoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public IPizzaInfo read(long id) {

        entityManager.getTransaction().begin();
        IPizzaInfo pizzaInfo = entityManager.find(PizzaInfo.class, id);
        entityManager.getTransaction().commit();

        return pizzaInfo;
    }

    @Override
    public List<IPizzaInfo> get() {

        //Criteria

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<IPizzaInfo> criteriaQuery = criteriaBuilder.createQuery(IPizzaInfo.class);
        Root<PizzaInfo> root = criteriaQuery.from(PizzaInfo.class);
        criteriaQuery.select(root)/*.where(criteriaBuilder.equal(root.get("size"), 60))*/;

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public IPizzaInfo create(IPizzaInfo item) {

        entityManager.getTransaction().begin();
        entityManager.persist(item);
        entityManager.getTransaction().commit();

        return item;
    }

    @Override
    public IPizzaInfo update(long id, LocalDateTime dtUpdate, IPizzaInfo item) {


        entityManager.getTransaction().begin();
        IPizzaInfo merge = entityManager.merge(item);
        entityManager.getTransaction().commit();

        return merge;

    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

        entityManager.getTransaction().begin();

        IPizzaInfo pizzaInfo = entityManager.find(PizzaInfo.class, id);
        entityManager.remove(pizzaInfo);

        entityManager.getTransaction().commit();

    }

}
