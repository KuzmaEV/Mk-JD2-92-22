package by.mk_jd2_92_22.pizzeria.services;

import by.mk_jd2_92_22.pizzeria.dao.entity.api.IOrder;
import by.mk_jd2_92_22.pizzeria.services.api.IOrderService;
import by.mk_jd2_92_22.pizzeria.services.dto.OrderDTO;
import by.mk_jd2_92_22.pizzeria.services.singleton.OrderServiceSingleton;
import org.junit.jupiter.api.Test;

import java.beans.PropertyVetoException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceTest {

    IOrderService service;

    {
        try {
            service = OrderServiceSingleton.getInstance();
        } catch (PropertyVetoException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

//    @Test
    public void read(){

        IOrder read = service.read(1);
        System.out.println(read);

    }

//    @Test
    public void get(){

        List<IOrder> orders = service.get();
        for (IOrder order : orders) {
            System.out.println(order);
        }


    }

//    @Test
    public void create(){

        List<OrderDTO.Selected> list = new ArrayList<>();
        list.add(new OrderDTO.Selected(1, 2));
        list.add(new OrderDTO.Selected(6, 1));
        list.add(new OrderDTO.Selected(8, 3));

        OrderDTO dto = new OrderDTO(list);

        IOrder order = service.create(dto);
        System.out.println(order);
    }

//    @Test
    public void update(){

        List<OrderDTO.Selected> list = new ArrayList<>();
        list.add(new OrderDTO.Selected(1, 3));
        list.add(new OrderDTO.Selected(8, 2));

        OrderDTO dto = new OrderDTO(list);

        LocalDateTime dtUpdate = service.read(13).getDtUpdate();
        IOrder order = service.update(13, dtUpdate, dto);
        System.out.println(order);
    }

//    @Test
    public void delete(){
        LocalDateTime dtUpdate = service.read(7).getDtUpdate();
        service.delete(7, dtUpdate);
    }

}
