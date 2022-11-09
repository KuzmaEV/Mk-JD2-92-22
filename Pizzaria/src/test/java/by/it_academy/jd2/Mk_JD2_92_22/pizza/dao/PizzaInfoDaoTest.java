package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.DtoPizzaInfoService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IPizzaInfoDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class PizzaInfoDaoTest {

    @Test
    public void create(){
        System.out.println("CREATE");

        IPizzaInfoDao data = PizzaInfoDaoSingleton.getInstance();

        DtoPizzaInfoService pizzaInfo = new DtoPizzaInfoService(LocalDateTime.now(),
                "createPizza", "Create pizzaInfo for CREATE", 40);

        IPizzaInfo savedPizzaInfo = data.create(pizzaInfo);
        System.out.println(savedPizzaInfo);

        Assertions.assertEquals(pizzaInfo.getName(), savedPizzaInfo.getName());
        data.delete(savedPizzaInfo.getId(), savedPizzaInfo.getDtUpdate());

        System.out.println("=".repeat(40));
        System.out.println();

    }
    @Test
    public void read() {
        System.out.println("READ");

        IPizzaInfoDao data = PizzaInfoDaoSingleton.getInstance();

        IPizzaInfo createdPizza = data.create(new DtoPizzaInfoService(   //Создал и сохранл пиццу в БД
                LocalDateTime.now(),
                "readPizza",
                "Create for testing READ",
                40));
        IPizzaInfo pizzaInfo = data.read(createdPizza.getId());
        System.out.println(pizzaInfo);

        Assertions.assertEquals("readPizza", pizzaInfo.getName());
        data.delete(pizzaInfo.getId(), pizzaInfo.getDtUpdate());

        System.out.println("=".repeat(40));
        System.out.println();
    }


    @Test
    public void get(){
        System.out.println("GET");

        IPizzaInfoDao data = PizzaInfoDaoSingleton.getInstance();
        List<IPizzaInfo> beforeSize = data.get();

        IPizzaInfo pizzaForTestGet = data.create(new DtoPizzaInfoService(
                LocalDateTime.now(),
                "PizzaForTestGet",
                "Create new pizzaInfo",
                40));


        System.out.println(pizzaForTestGet);

        List<IPizzaInfo> afterSize = data.get();

        Assertions.assertNotNull(afterSize);
        Assertions.assertEquals(beforeSize.size() + 1,afterSize.size());

        data.delete(pizzaForTestGet.getId(), pizzaForTestGet.getDtUpdate());

        System.out.println("=".repeat(40));
        System.out.println();
    }

    @Test
    public void update(){
        System.out.println("UPDATE");

        IPizzaInfoDao data = PizzaInfoDaoSingleton.getInstance();

        IPizzaInfo createdPizza = data.create(new DtoPizzaInfoService(// Создал и добавил пиццу в БД
                LocalDateTime.now(),
                "createdPizza",
                "Create for testing Update",
                41));

        DtoPizzaInfoService updatePizza = new DtoPizzaInfoService( // Создал пиццу для обнавления
                LocalDateTime.now(),
                "PizzaUpdate",
                "Update For testing Update",
                42);

//        IPizzaInfo notUpdatedPizza = new PizzaInfo(0,  // Создал пиццу которая не сможет обнавиться(даты обнавления разные)
//                createdPizza.getDtCreate(),
//                LocalDateTime.now(),
//                "NotUpdated",
//                "For testing Update",
//                43);

        IPizzaInfo update = data.update(createdPizza.getId(), // Обнавил пиццу
                createdPizza.getDtUpdate(),
                updatePizza);

        System.out.println(update);

//        IPizzaInfo notUpdate = data.update(createdPizza.getId(), // НЕ обнавиться(даты обнавления разные)
//                createdPizza.getDtUpdate(),
//                notUpdatedPizza);

        Assertions.assertNotEquals(createdPizza.getName(), update.getName()); // Сазданная и обнавленная пиццы разные
        Assertions.assertEquals(updatePizza.getName(), update.getName());
//       Assertions.assertEquals(update.getName(), notUpdate.getName()); // Пицца которая не смогла обнавиться венула старую пиццу

        data.delete(createdPizza.getId(), update.getDtUpdate());

        System.out.println("=".repeat(40));
        System.out.println();
    }

    @Test
    public void delete(){
        System.out.println("DELETE");

        IPizzaInfoDao data = PizzaInfoDaoSingleton.getInstance();

        IPizzaInfo createdPizza = data.create(new DtoPizzaInfoService(  //Создал и сохранл пиццу в БД
                LocalDateTime.now(),
                "deletePizza",
                "Create for testing DELETE",
                45));

        DtoPizzaInfoService updatePizza = new DtoPizzaInfoService(   //создал экземпляр пиццы для обнавления
                LocalDateTime.now(),
                "PizzaUpdate",
                "Update For testing DELETE",
                42);

        IPizzaInfo update = data.update(createdPizza.getId(),  // Обнавил пиццу, чтобы проверить лок
                createdPizza.getDtUpdate(), updatePizza);

        int sizeBefore = data.get().size(); // Количество строк в БД после дабавления


//        data.delete(createdPizza.getId(),
//                createdPizza.getDtUpdate()); // Попытается удалить, но должен сработать лок(дата обнавления не совпадает)
//
//        int size = data.get().size();

        data.delete(update.getId(),    //Удалить пиццу из БД (время обновления совпвдает)
                update.getDtUpdate());

        int sizeAfter = data.get().size();  // Количество строк в БД после удаления( на 1 меньше чем было)



        Assertions.assertEquals(sizeBefore - 1,sizeAfter);
//        Assertions.assertEquals(sizeBefore, size);




    }

}
