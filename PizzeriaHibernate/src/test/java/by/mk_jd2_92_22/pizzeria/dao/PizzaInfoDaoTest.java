package by.mk_jd2_92_22.pizzeria.dao;

import by.mk_jd2_92_22.pizzeria.core.entity.api.IPizzaInfo;
import by.mk_jd2_92_22.pizzeria.dao.api.IPizzaInfoDao;
import by.mk_jd2_92_22.pizzeria.dao.sindleton.PizzaInfoDaoSingleton;

import org.junit.jupiter.api.Test;

public class PizzaInfoDaoTest {

    @Test
            public void read() {
        IPizzaInfoDao dao = PizzaInfoDaoSingleton.getInstance();

        long id = 49;

         IPizzaInfo read = dao.read(id);

        System.out.println(read);

    }


}
