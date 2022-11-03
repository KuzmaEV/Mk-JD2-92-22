package by.it_academy.jd2.Mk_JD2_92_22.pizza.storages;

import by.it_academy.jd2.Mk_JD2_92_22.garbage.storages.FilePizzaInfoStorage;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.garbage.storages.entity.PizzaInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FilePizzaInfoStorageTest {

    @Test
    public void save(){
        System.out.println(System.getenv("CATALINA_HOME"));
        FilePizzaInfoStorage storage = new FilePizzaInfoStorage();
        IPizzaInfo pizzaInfo = new PizzaInfo("SaveStorage", "save pizzaInfo", 1);
        storage.save(pizzaInfo);
        System.out.println(pizzaInfo.getName());

        Assertions.assertEquals(pizzaInfo.getName(), storage.get("SaveStorage").getName());

        storage.delete("SaveStorage");
    }


    @Test
    public void get(){
        FilePizzaInfoStorage storage = new FilePizzaInfoStorage();
        List<IPizzaInfo> beforeSize = storage.get();

        storage.save(new PizzaInfo("StorageGet", "getList", 1));

        for (IPizzaInfo pizzaInfo : storage.get()) {
            System.out.println("pizza: " + pizzaInfo.getName());
            System.out.println("description: " + pizzaInfo.getDescription());
            System.out.println("size: " + pizzaInfo.getSize() + " cm");
            System.out.println();
        }

        System.out.println("=".repeat(40));

        List<IPizzaInfo> afterSize = storage.get();

        Assertions.assertNotNull(storage.get());
        Assertions.assertEquals(beforeSize.size() + 1,afterSize.size());

        storage.delete("StorageGet");
    }

    @Test
    public void delete(){

        FilePizzaInfoStorage storage = new FilePizzaInfoStorage();

        PizzaInfo pizzaHunting = new PizzaInfo("Delete", "delete", 1);
        storage.save(pizzaHunting);

        int sizeBefore = storage.get().size();

        storage.delete(pizzaHunting.getName());

        int sizeAfter = storage.get().size();

        Assertions.assertEquals(sizeBefore - 1,sizeAfter);


    }

}
