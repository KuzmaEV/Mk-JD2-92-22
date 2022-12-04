package by.mk_jd2_92_22.pizzeria.services;

import by.mk_jd2_92_22.pizzeria.dao.entity.api.IMenu;
import by.mk_jd2_92_22.pizzeria.services.api.IMenuService;
import by.mk_jd2_92_22.pizzeria.services.dto.MenuDTO;
import by.mk_jd2_92_22.pizzeria.services.singleton.MenuServiceSingleton;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MenuServiceTest {

    private final IMenuService service = MenuServiceSingleton.getInstance();

//    @Test
    public void read(){
        IMenu menu = service.read(5);

        System.out.println(menu);
    }

//    @Test
    public void get(){
        List<IMenu> menus = service.get();
        for (IMenu menu : menus) {
            System.out.println(menu);
        }
    }

//    @Test
    public void create(){

         MenuDTO dto = new MenuDTO("MenuForTest", true);

        IMenu menu = service.create(dto);

        System.out.println(menu);

    }

//    @Test
    public void update(){

        MenuDTO dto = new MenuDTO();
        dto.setName("Testing");

        MenuDTO dto1 = new MenuDTO();
        dto1.setEnabled(true);

        MenuDTO dto2 = new MenuDTO("Ok", true);

        IMenu read = service.read(4);

        IMenu menu = service.update(4, read.getDtUpdate(), dto);
        System.out.println(menu);
        IMenu menu2 = service.update(4, menu.getDtUpdate(), dto1);
        System.out.println(menu2);
        IMenu menu3 = service.update(4, menu2.getDtUpdate(), dto2);
        System.out.println(menu3);



    }

//    @Test
    public void delete(){
        IMenu read = service.read(5);
        service.delete(5, read.getDtUpdate());
    }
}
