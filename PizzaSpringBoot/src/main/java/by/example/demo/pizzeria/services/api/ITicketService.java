package by.example.demo.pizzeria.services.api;

import by.example.demo.pizzeria.dao.entity.Order;
import by.example.demo.pizzeria.dao.entity.Ticket;

public interface ITicketService extends IService<Ticket, Order> {
    void resetTicket();
}
