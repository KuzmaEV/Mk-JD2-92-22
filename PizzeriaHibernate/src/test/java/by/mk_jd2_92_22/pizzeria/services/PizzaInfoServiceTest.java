package by.mk_jd2_92_22.pizzeria.services;

import by.mk_jd2_92_22.pizzeria.core.entity.api.IPizzaInfo;
import by.mk_jd2_92_22.pizzeria.services.api.IPizzaInfoService;
import by.mk_jd2_92_22.pizzeria.services.dto.PizzaInfoDTO;
import by.mk_jd2_92_22.pizzeria.services.singleton.PizzaInfoServiceSingleton;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PizzaInfoServiceTest {

    @Test
    public void get(){

        IPizzaInfoService service = PizzaInfoServiceSingleton.getInstance();

        List<IPizzaInfo> pizzaInfoList = service.get();

        for (IPizzaInfo pizzaInfo : pizzaInfoList) {
            System.out.println(pizzaInfo);
        }

    }

    @Test
    public void create(){

        IPizzaInfoService service = PizzaInfoServiceSingleton.getInstance();

        PizzaInfoDTO dto = new PizzaInfoDTO(
                "PizzaHibernate",
                "To check CREATE pizzaInfo",
                40);

        IPizzaInfo pizzaInfo = service.create(dto);

        System.out.println(pizzaInfo);
    }
}
