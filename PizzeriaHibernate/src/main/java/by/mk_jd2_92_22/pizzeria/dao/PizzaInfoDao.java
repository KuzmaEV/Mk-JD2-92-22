package by.mk_jd2_92_22.pizzeria.dao;


import by.mk_jd2_92_22.pizzeria.core.entity.PizzaInfo;
import by.mk_jd2_92_22.pizzeria.core.entity.api.IPizzaInfo;
import by.mk_jd2_92_22.pizzeria.dao.api.IPizzaInfoDao;
import by.mk_jd2_92_22.pizzeria.services.dto.PizzaInfoDTO;

import javax.persistence.EntityManager;

import java.time.LocalDateTime;

import java.util.List;

public class PizzaInfoDao implements IPizzaInfoDao {


    @Override
    public IPizzaInfo read(long id) {

        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        entityManager.getTransaction().begin();
        PizzaInfo pizzaInfo = entityManager.find(PizzaInfo.class, id);
        entityManager.getTransaction().commit();
        
        EntityManagerUtil.close();


        return pizzaInfo;
    }

    @Override
    public List<IPizzaInfo> get() {


return null;
    }

    @Override
    public IPizzaInfo create(PizzaInfoDTO item) {

        return null;
    }

    @Override
    public IPizzaInfo update(long id, LocalDateTime dtUpdate, PizzaInfoDTO item) {


            return read(id);

    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

    }

}
