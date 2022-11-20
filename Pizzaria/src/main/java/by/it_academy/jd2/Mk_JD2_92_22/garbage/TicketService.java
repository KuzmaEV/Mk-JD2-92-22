package by.it_academy.jd2.Mk_JD2_92_22.garbage;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.ITicket;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.TicketDTO;

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
