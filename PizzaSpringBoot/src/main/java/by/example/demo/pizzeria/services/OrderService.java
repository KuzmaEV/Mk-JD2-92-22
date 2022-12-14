package by.example.demo.pizzeria.services;


import by.example.demo.pizzeria.dao.entity.SelectedItem;
import by.example.demo.pizzeria.dao.api.IOrderDao;
import by.example.demo.pizzeria.dao.entity.Order;
import by.example.demo.pizzeria.dao.entity.Ticket;
import by.example.demo.pizzeria.services.api.IMenuRowService;
import by.example.demo.pizzeria.services.api.IOrderService;
import by.example.demo.pizzeria.services.api.IOrderStatusService;
import by.example.demo.pizzeria.services.api.ITicketService;
import by.example.demo.pizzeria.services.dto.OrderDTO;
import by.example.demo.pizzeria.services.dto.OrderStatusDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderService implements IOrderService {

    private final IOrderDao dao;
    private final IMenuRowService menuRowService;
    private final IOrderStatusService orderStatusService;
    private final ITicketService ticketService;

    public OrderService(IOrderDao dao, IMenuRowService menuRowService,
                        IOrderStatusService orderStatusService, ITicketService ticketService) {
        this.dao = dao;
        this.menuRowService = menuRowService;
        this.orderStatusService = orderStatusService;
        this.ticketService = ticketService;
    }

    @Override
    public Order read(long id) {

        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<Order> get() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public Order create(OrderDTO item) {

        List<SelectedItem> listSelected = mapperListSelectedItem(item.getSelectedItem());

        Order order = new Order(
            LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS),
            LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS),
            listSelected
        );

        Order saveOrder = dao.save(order);

        Ticket ticket = ticketService.create(saveOrder);

        OrderStatusDTO orderStatusDTO = new OrderStatusDTO();
        orderStatusDTO.setTicket(ticket);
        orderStatusDTO.setStageDescription("Заказ принят.");
        orderStatusDTO.setDone(false);
        orderStatusService.create(orderStatusDTO);

        return saveOrder;
    }

    @Override
    @Transactional
    public Order update(long id, LocalDateTime dtUpdate, OrderDTO item) {

        Order order = dao.findById(id).orElseThrow();


        if (!order.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Не удалось обнавить данные, кто-то отредактировал раньше!");
        }

        order.setDtUpdate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));

        order.setSelectedItem(mapperListSelectedItem(item.getSelectedItem()));

        return dao.save(order);
    }


    @Override
    @Transactional
    public void delete(long id, LocalDateTime dtUpdate) {

        Order order = dao.findById(id).orElseThrow();

        if (!order.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Не удалось удалить данные, кто-то отредактировал раньше!");
        }

        dao.deleteById(id);

    }
    private List<SelectedItem> mapperListSelectedItem(List<OrderDTO.Selected> selectedItem){

        List<SelectedItem> listSelected = new ArrayList<>();

        for (OrderDTO.Selected row : selectedItem) {

            SelectedItem selectedRow = new SelectedItem();
            selectedRow.setMenuRow(menuRowService.read(row.getMenuRow()));
            selectedRow.setCount(row.getCount());

            listSelected.add(selectedRow);
        }
        return listSelected;
    }

}
