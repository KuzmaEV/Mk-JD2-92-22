package by.example.demo.pizzeria.services;

import by.example.demo.pizzeria.dao.api.ITicketDao;
import by.example.demo.pizzeria.dao.entity.Order;
import by.example.demo.pizzeria.dao.entity.Ticket;
import by.example.demo.pizzeria.services.api.ITicketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class TicketService implements ITicketService {

    private final ITicketDao dao;

    public TicketService(ITicketDao dao) {
        this.dao = dao;
    }

    @Override
    public Ticket read(long id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public List<Ticket> get() {
        return dao.findAll();
    }

    @Transactional
    @Override
    public Ticket create(Order item) {

        Ticket ticket = new Ticket(LocalDateTime.now(), item);
        return dao.save(ticket);
    }

    @Override
    @Transactional
    public Ticket update(long id, LocalDateTime dtUpdate, Order item) {
        return null;
    }

    @Override
    @Transactional
    public void delete(long id, LocalDateTime dtUpdate) {

    }

    @Override
    @Transactional
    public void resetTicket() {
        dao.resetTicket();
    }
}
