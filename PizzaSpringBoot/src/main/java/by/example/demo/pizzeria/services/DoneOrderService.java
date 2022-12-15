package by.example.demo.pizzeria.services;

import by.example.demo.pizzeria.dao.entity.PizzaInfo;
import by.example.demo.pizzeria.dao.entity.SelectedItem;
import by.example.demo.pizzeria.dao.entity.Ticket;
import by.example.demo.pizzeria.dao.entity.core.DoneOrder;
import by.example.demo.pizzeria.dao.entity.core.Pizza;
import by.example.demo.pizzeria.services.api.IDoneOrderService;
import by.example.demo.pizzeria.services.api.ITicketService;

import java.util.ArrayList;
import java.util.List;

public class DoneOrderService implements IDoneOrderService {

    private final ITicketService ticketService;

    public DoneOrderService(ITicketService ticketService) {
        this.ticketService = ticketService;
    }



   @Override
    public DoneOrder get(long item) {

        Ticket ticket = ticketService.read(item);

        List<Pizza> pizzaList = new ArrayList<>();

        List<SelectedItem> selectedItem = ticket.getOrder().getSelectedItem();
        for (SelectedItem selected : selectedItem) {

            PizzaInfo info = selected.getMenuRow().getInfo();

            Pizza pizza = new Pizza(info.getName(), info.getSize());
            pizzaList.add(pizza);
        }

        return new DoneOrder(ticket, pizzaList);
    }


}
