package by.it_academy.jd2.Mk_JD2_92_22.pizza.services;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.ITicket;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.dto.OrderDTO;
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
    public ITicket read(long id) {

        return dao.read(id);
    }

    @Override
    public List<ITicket> get() {
        return dao.get();
    }

    @Override
    public ITicket create(OrderDTO item) {

        item.setDtUpdate(LocalDateTime.now());

        return dao.create(item);
    }

    @Override
    public ITicket update(long id, LocalDateTime dtUpdate, OrderDTO item) {
        return null;
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

        dao.delete(id, dtUpdate);

    }
}
