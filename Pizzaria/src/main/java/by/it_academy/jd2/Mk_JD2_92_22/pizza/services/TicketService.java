package by.it_academy.jd2.Mk_JD2_92_22.pizza.services;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.ITicket;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.TicketDTO;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.ITicketDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.ITicketService;

import java.time.LocalDateTime;
import java.util.List;

public class TicketService implements ITicketService{

    private final ITicketDao dao;

    public TicketService(ITicketDao dao) {
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
    public ITicket create(TicketDTO item) {

        item.setDtCreate(LocalDateTime.now());

        return dao.create(item);
    }

    @Override
    public ITicket update(long id, LocalDateTime dtUpdate, TicketDTO item) {
        return null;
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {
        dao.delete(id, dtUpdate);

    }
}
