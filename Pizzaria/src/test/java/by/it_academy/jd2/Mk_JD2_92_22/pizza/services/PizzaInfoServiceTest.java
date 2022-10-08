package by.it_academy.jd2.Mk_JD2_92_22.pizza.services;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.menu.PizzaInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PizzaInfoServiceTest {

    @Test
    public void get(){
        PizzaInfoService service = PizzaInfoService.getInstance();

        service.validate(new PizzaInfo("Margarita", "tomatoes, cheese", 40));

        IPizzaInfo pizzaInfo = service.get("Margarita");

        Assertions.assertEquals("tomatoes, cheese", pizzaInfo.getDescription());
    }

    @Test
    public void validate(){
        PizzaInfoService service = PizzaInfoService.getInstance();
        IPizzaInfo pizzaInfo = new PizzaInfo("Mexican", "pepper", 40);

        service.validate(pizzaInfo);

        Assertions.assertEquals(pizzaInfo.getDescription(), service.get("Mexican").getDescription());
    }
}
