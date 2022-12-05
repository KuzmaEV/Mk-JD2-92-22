package by.mk_jd2_92_22.pizzeria.services;


import by.mk_jd2_92_22.pizzeria.dao.api.IOrderDao;
import by.mk_jd2_92_22.pizzeria.dao.entity.Order;
import by.mk_jd2_92_22.pizzeria.dao.entity.SelectedItem;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.IOrder;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.ISelectedItem;
import by.mk_jd2_92_22.pizzeria.services.api.IMenuRowService;
import by.mk_jd2_92_22.pizzeria.services.api.IOrderService;
import by.mk_jd2_92_22.pizzeria.services.dto.OrderDTO;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOrderService {

    private final IOrderDao dao;
    private final IMenuRowService menuRowService;

    public OrderService(IOrderDao dao, IMenuRowService menuRowService) {
        this.dao = dao;
        this.menuRowService = menuRowService;
    }

    @Override
    public IOrder read(long id) {

        return dao.read(id);
    }

    @Override
    public List<IOrder> get() {
        return dao.get();
    }

    @Override
    public IOrder create(OrderDTO item) {

        List<ISelectedItem> listSelected = mapperListSelectedItem(item.getSelectedItem());

        IOrder order = new Order(
            LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS),
            LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS),
            listSelected
        );

        return dao.create(order);
    }

    @Override
    public IOrder update(long id, LocalDateTime dtUpdate, OrderDTO item) {

        IOrder order = dao.read(id);

        if (order == null){
            throw new IllegalArgumentException("Заказ не найдено!");
        }
        if (!order.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Не удалось обнавить данные, кто-то отредактировал раньше!");
        }

        order.setDtUpdate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));

        order.setSelectedItem(mapperListSelectedItem(item.getSelectedItem()));

        return dao.update(id, dtUpdate, order);
    }


    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

        IOrder order = dao.read(id);

        if (order == null){
            throw new IllegalArgumentException("Заказ не найдено!");
        }
        if (!order.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Не удалось удалить данные, кто-то отредактировал раньше!");
        }

        dao.delete(id, dtUpdate);

    }
    private List<ISelectedItem> mapperListSelectedItem(List<OrderDTO.Selected> selectedItem){

        List<ISelectedItem> listSelected = new ArrayList<>();

        for (OrderDTO.Selected row : selectedItem) {

            ISelectedItem selectedRow = new SelectedItem();
            selectedRow.setMenuRow(menuRowService.read(row.getMenuRow()));
            selectedRow.setCount(row.getCount());

            listSelected.add(selectedRow);
        }
        return listSelected;
    }

}
