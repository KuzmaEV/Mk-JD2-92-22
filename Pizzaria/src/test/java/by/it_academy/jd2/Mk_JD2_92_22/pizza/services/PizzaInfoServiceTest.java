package by.it_academy.jd2.Mk_JD2_92_22.pizza.services;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.storages.entity.PizzaInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PizzaInfoServiceTest {

    @Test
    public void get(){
        PizzaInfoService service = PizzaInfoService.getInstance();

            service.validate(new PizzaInfo("ServiceGet", "get PizzaInfo", 1));

            IPizzaInfo pizzaInfo = service.get("ServiceGet");

        Assertions.assertEquals("get PizzaInfo", pizzaInfo.getDescription());

        service.delete("ServiceGet");
    }

    @Test
    public void validate(){
        PizzaInfoService service = PizzaInfoService.getInstance();
        IPizzaInfo pizzaInfo = new PizzaInfo("ValidateService", "validate", 1);

        service.validate(pizzaInfo);

        Assertions.assertEquals(pizzaInfo.getDescription(), service.get("ValidateService").getDescription());

        service.delete("ValidateService");
    }

    @Test
    public void delete(){
        PizzaInfoService service = PizzaInfoService.getInstance();

        service.validate(new PizzaInfo("DeleteService", "delete", 1));

        int sizeBefore = service.get().size();

        service.delete("DeleteService");

        int sizeAfter = service.get().size();

        Assertions.assertEquals(sizeBefore - 1, sizeAfter);
    }
}
