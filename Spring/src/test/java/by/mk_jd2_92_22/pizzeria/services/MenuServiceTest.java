package by.mk_jd2_92_22.pizzeria.services;

import by.mk_jd2_92_22.pizzeria.dao.entity.Menu;
import by.mk_jd2_92_22.pizzeria.dao.entity.PizzaInfo;
import by.mk_jd2_92_22.pizzeria.services.api.IMenuService;
import by.mk_jd2_92_22.pizzeria.services.api.IPizzaInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MenuServiceTest {

//    @Test
    public void get(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("pizza.xml");

        IMenuService bean = context.getBean(IMenuService.class);

        List<Menu> pizza = bean.get();

        for (Menu pizzaInfo : pizza) {
            System.out.println(pizzaInfo);
        }
    }
}
