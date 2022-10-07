package by.it_academy.jd2.Mk_JD2_92_22.pizza.storages;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.menu.PizzaInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FilePizzaInfoStorageTest {

    @Test
    public void save(){
        System.out.println(System.getenv("CATALINA_HOME"));
        FilePizzaInfoStorage storage = new FilePizzaInfoStorage();
        IPizzaInfo pizzaInfo = new PizzaInfo("Pepperoni", "Клбаса, сыр", 40);
        storage.save(pizzaInfo);
        System.out.println(pizzaInfo.getName());

        Assertions.assertEquals(pizzaInfo.getName(), storage.get("Pepperoni").getName());
    }


    @Test
    public void get(){
        FilePizzaInfoStorage storage = new FilePizzaInfoStorage();
        List<IPizzaInfo> beforeSize = storage.get();

        storage.save(new PizzaInfo("Four cheeses", "cheese", 40));

        for (IPizzaInfo pizzaInfo : storage.get()) {
            System.out.println("pizza: " + pizzaInfo.getName());
            System.out.println("description: " + pizzaInfo.getDescription());
            System.out.println("size: " + pizzaInfo.getSize() + " cm");
        }


        List<IPizzaInfo> afterSize = storage.get();

        Assertions.assertNotNull(storage.get());
        Assertions.assertEquals(beforeSize.size() + 1,afterSize.size());
    }

}
