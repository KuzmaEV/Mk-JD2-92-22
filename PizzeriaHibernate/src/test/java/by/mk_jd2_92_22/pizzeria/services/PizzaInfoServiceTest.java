package by.mk_jd2_92_22.pizzeria.services;

import by.mk_jd2_92_22.pizzeria.core.entity.api.IPizzaInfo;
import by.mk_jd2_92_22.pizzeria.services.api.IPizzaInfoService;
import by.mk_jd2_92_22.pizzeria.services.dto.PizzaInfoDTO;
import by.mk_jd2_92_22.pizzeria.services.singleton.PizzaInfoServiceSingleton;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class PizzaInfoServiceTest {

    IPizzaInfoService service = PizzaInfoServiceSingleton.getInstance();

    @Test
    public void get(){

        List<IPizzaInfo> pizzaInfoList = service.get();

        for (IPizzaInfo pizzaInfo : pizzaInfoList) {
            System.out.println(pizzaInfo);
        }

    }

    @Test
    public void create(){

        PizzaInfoDTO dto = new PizzaInfoDTO(
                "PizzaHibernate",
                "To check CREATE pizzaInfo",
                40);

        IPizzaInfo pizzaInfo = service.create(dto);

        System.out.println(pizzaInfo);
    }

    @Test
    public void update(){

        IPizzaInfo pizzaInfo = service.read(324);


        PizzaInfoDTO dto = new PizzaInfoDTO();

        dto.setName("updateHibernate");
        dto.setDescription("UPDATE pizzaInfo - Ok");
        dto.setSize(45);

        service.update(324, pizzaInfo.getDtUpdate(), dto);

        System.out.println(service.read(324));
    }
    @Test
    void delete(){
        IPizzaInfo read = service.read(325);
        LocalDateTime dtUpdate = read.getDtUpdate();

        service.delete(325,dtUpdate);

    }
}
