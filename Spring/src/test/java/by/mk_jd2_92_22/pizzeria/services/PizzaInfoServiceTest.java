package by.mk_jd2_92_22.pizzeria.services;

import by.mk_jd2_92_22.pizzeria.dao.entity.PizzaInfo;
import by.mk_jd2_92_22.pizzeria.services.api.IPizzaInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PizzaInfoServiceTest {

//    @Test
    public void get(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("pizza.xml");

        IPizzaInfoService bean = context.getBean(IPizzaInfoService.class);

        List<PizzaInfo> pizza = bean.get();

        for (PizzaInfo pizzaInfo : pizza) {
            System.out.println(pizzaInfo);
        }
    }

//    @Test
    public void read(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("pizza.xml");

        IPizzaInfoService bean = context.getBean(IPizzaInfoService.class);

        System.out.println(bean.read(49));


    }
}
