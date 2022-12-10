package by.mk_jd2_92_22.pizzeria.services;


import by.mk_jd2_92_22.pizzeria.dao.api.IOrderDao;
import by.mk_jd2_92_22.pizzeria.dao.entity.Order;
import by.mk_jd2_92_22.pizzeria.dao.entity.SelectedItem;
import by.mk_jd2_92_22.pizzeria.services.api.IMenuRowService;
import by.mk_jd2_92_22.pizzeria.services.api.IOrderService;
import by.mk_jd2_92_22.pizzeria.services.dto.OrderDTO;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = true)
public class OrderService implements IOrderService {

    private final IOrderDao dao;
    private final IMenuRowService menuRowService;

    public OrderService(IOrderDao dao, IMenuRowService menuRowService) {
        this.dao = dao;
        this.menuRowService = menuRowService;
    }

    @Override
    public Order read(long id) {

        return dao.getReferenceById(id);
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

        return dao.save(order);
    }

    @Override
    @Transactional
    public Order update(long id, LocalDateTime dtUpdate, OrderDTO item) {

        Order order = dao.getReferenceById(id);

        if (order == null){
            throw new IllegalArgumentException("Заказ не найдено!");
        }
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

        Order order = dao.getReferenceById(id);

        if (order == null){
            throw new IllegalArgumentException("Заказ не найдено!");
        }
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
