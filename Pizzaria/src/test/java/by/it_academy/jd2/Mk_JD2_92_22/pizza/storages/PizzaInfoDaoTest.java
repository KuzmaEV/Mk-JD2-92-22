package by.it_academy.jd2.Mk_JD2_92_22.pizza.storages;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.PizzaInfoDaoSingleton;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IPizzaInfoDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.PizzaInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class PizzaInfoDaoTest {

    @Test
    public void create(){
        IPizzaInfoDao pizzaInfoDao = PizzaInfoDaoSingleton.getInstance();

        IPizzaInfo pizzaInfo = new PizzaInfo(0, LocalDateTime.now(), LocalDateTime.now(),
                "Save", "SaveDescription", 40);
        System.out.println(pizzaInfo);

        IPizzaInfo savedPizzaInfoDao = pizzaInfoDao.create(pizzaInfo);

        Assertions.assertEquals(pizzaInfo.getName(), savedPizzaInfoDao.getName());

        System.out.println("=".repeat(40));
        System.out.println();

    }
    @Test
    public void read() {
        IPizzaInfoDao pizzaInfoDao = PizzaInfoDaoSingleton.getInstance();

        IPizzaInfo pizzaInfo = pizzaInfoDao.read(3);
        System.out.println(pizzaInfo);
        Assertions.assertEquals("pizza", pizzaInfo.getName());

        System.out.println("=".repeat(40));
        System.out.println();
    }


    @Test
    public void get(){

        IPizzaInfoDao data = PizzaInfoDaoSingleton.getInstance();
        List<IPizzaInfo> beforeSize = data.get();

        IPizzaInfo pizzaForTestGet = data.create(new PizzaInfo(0, LocalDateTime.now(),
                LocalDateTime.now(),
                "PizzaForTestGet",
                "Create new pizzaInfo",
                40));


        System.out.println(pizzaForTestGet);


        List<IPizzaInfo> afterSize = data.get();

        Assertions.assertNotNull(afterSize);
        Assertions.assertEquals(beforeSize.size() + 1,afterSize.size());

        System.out.println("=".repeat(40));
        System.out.println();
    }

    @Test
    public void update(){

        IPizzaInfoDao data = PizzaInfoDaoSingleton.getInstance();

        IPizzaInfo createdPizza = data.create(new PizzaInfo(0,
                LocalDateTime.now(),
                LocalDateTime.now(),
                "createdPizza",
                "Create for testing Update",
                41));

        IPizzaInfo updatePizza = new PizzaInfo(0,
                createdPizza.getDtCreate(),
                LocalDateTime.now(),
                "PizzaUpdate",
                "Update For testing Update",
                42);

        IPizzaInfo notUpdatedPizza = new PizzaInfo(0,
                createdPizza.getDtCreate(),
                LocalDateTime.now(),
                "NotUpdated",
                "For testing Update",
                43);

        IPizzaInfo update = data.update(createdPizza.getId(),
                createdPizza.getDtUpdate(),
                updatePizza);

        IPizzaInfo notUpdate = data.update(createdPizza.getId(),
                createdPizza.getDtUpdate(),
                notUpdatedPizza);

        Assertions.assertNotEquals(createdPizza.getName(), update.getName());
        Assertions.assertEquals(updatePizza.getName(), update.getName());
        Assertions.assertEquals(update.getName(), notUpdate.getName());
        Assertions.assertNotEquals(notUpdatedPizza, updatePizza);

        System.out.println("=".repeat(40));
        System.out.println();
    }
//
//    @Test
//    public void delete(){
//
//        FilePizzaInfoStorage storage = new FilePizzaInfoStorage();
//
//        PizzaInfo pizzaHunting = new PizzaInfo("Delete", "delete", 1);
//        storage.save(pizzaHunting);
//
//        int sizeBefore = storage.get().size();
//
//        storage.delete(pizzaHunting.getName());
//
//        int sizeAfter = storage.get().size();
//
//        Assertions.assertEquals(sizeBefore - 1,sizeAfter);
//
//
//    }

}
