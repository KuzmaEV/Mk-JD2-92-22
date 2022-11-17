package by.it_academy.jd2.Mk_JD2_92_22.pizza.services;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IOrder;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.OrderDTO;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IOrderDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IOrderService;

import java.time.LocalDateTime;
import java.util.List;

public class OrderService implements IOrderService {

    private final IOrderDao dao;

    public OrderService(IOrderDao dao) {
        this.dao = dao;
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

        item.setDtUpdate(LocalDateTime.now());

        return dao.create(item);
    }

    @Override
    public IOrder update(long id, LocalDateTime dtUpdate, OrderDTO item) {
        return null;
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

    }
}
