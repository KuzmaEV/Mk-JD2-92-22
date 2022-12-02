package by.mk_jd2_92_22.pizzeria.services;

import by.mk_jd2_92_22.pizzeria.dao.entity.api.IMenuRow;
import by.mk_jd2_92_22.pizzeria.services.api.IMenuRowService;
import by.mk_jd2_92_22.pizzeria.services.dto.MenuRowDTO;
import by.mk_jd2_92_22.pizzeria.services.singleton.MenuRowServiceSingleton;


import java.time.LocalDateTime;
import java.util.List;

public class MenuRowServiceTest {

    IMenuRowService service = MenuRowServiceSingleton.getInstance();

//    @Test
    public void create() {

        MenuRowDTO dto = new MenuRowDTO(49, 10, 1);

        IMenuRow menuRow = service.create(dto);
        System.out.println(menuRow);


    }

//    @Test
    public void get(){


        List<IMenuRow> menuRows = service.get();

        System.out.println(menuRows);
    }

//    @Test
    public void read(){

        IMenuRow menuRow = service.read(1);

        System.out.println(menuRow);
    }

 //   @Test
    public void update(){

        MenuRowDTO dto = new MenuRowDTO();
        dto.setPrice(9999);

        IMenuRow readMenuRow = service.read(9);
        LocalDateTime dtUpdate = readMenuRow.getDtUpdate();

        IMenuRow menuRow = service.update(9, dtUpdate, dto);

        System.out.println(menuRow);

    }

 //   @Test
    public void delete(){

        IMenuRow menuRow = service.read(10);

        service.delete(10, menuRow.getDtUpdate());


    }



}
