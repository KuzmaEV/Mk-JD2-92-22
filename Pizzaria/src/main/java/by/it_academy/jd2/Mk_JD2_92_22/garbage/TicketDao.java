package by.it_academy.jd2.Mk_JD2_92_22.garbage;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.*;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.dto.TicketDTO;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.*;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TicketDao implements ITicketDao {

    private final DataSource ds;

    private static final String READ_TICKET_SQL = "SELECT ticket.id, ticket.dt_create,\n" +
            "\"order\".id, \"order\".dt_create, \"order\".dt_update" +
            "\tFROM pizzeria.ticket\n" +
            "\tINNER JOIN pizzeria.\"order\" ON ticket.\"order\" = \"order\".id\n" +
            "\tWHERE ticket.id = ?;";

    private static final String READ_SELECTED_SQL = "SELECT selected_item.id, \"count\",\n" +
            "\tmenu_row.id, menu_row.dt_create, menu_row.dt_update, price, menu,\n" +
            "\tinfo, pizza_info.dt_create, pizza_info.dt_update, name, description, size \n" +
            "\tFROM pizzeria.ticket\n" +
            "\tINNER JOIN pizzeria.\"order\" ON ticket.\"order\" = \"order\".id\n" +
            "\tINNER JOIN pizzeria.selected_item ON \"order\".id = selected_item.\"order\"\n" +
            "\tINNER JOIN pizzeria.menu_row ON selected_item.menu_row = menu_row.id\n" +
            "\tINNER JOIN pizzeria.pizza_info ON menu_row.info = pizza_info.id\n" +
            "\tWHERE ticket.id = ?;";

    private static final String GET_TICKET_SQL = "SELECT ticket.id, ticket.dt_create,\n" +
            "\"order\".id, \"order\".dt_create, \"order\".dt_update" +
            "\tFROM pizzeria.ticket\n" +
            "\tINNER JOIN pizzeria.\"order\" ON ticket.\"order\" = \"order\".id";

    private static final String GET_SELECTED_SQL = "SELECT selected_item.id, \"count\",\n" +
            "\tmenu_row.id, menu_row.dt_create, menu_row.dt_update, price, menu,\n" +
            "\tinfo, pizza_info.dt_create, pizza_info.dt_update, name, description, size \n" +
            "\tFROM pizzeria.ticket\n" +
            "\tINNER JOIN pizzeria.\"order\" ON ticket.\"order\" = \"order\".id\n" +
            "\tINNER JOIN pizzeria.selected_item ON \"order\".id = selected_item.\"order\"\n" +
            "\tINNER JOIN pizzeria.menu_row ON selected_item.menu_row = menu_row.id\n" +
            "\tINNER JOIN pizzeria.pizza_info ON menu_row.info = pizza_info.id";

    private static final String CREATE_SQL = "";
    private static final String DELETE_SQL = "";

    public TicketDao(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public ITicket read(long id) {
        try(Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(READ_TICKET_SQL);
            PreparedStatement psSelected = conn.prepareStatement(READ_SELECTED_SQL)) {

            ps.setLong(1, id);
            psSelected.setLong(1, id);

            try(ResultSet rs = ps.executeQuery();
                ResultSet rsSelected = psSelected.executeQuery()){

                return mapper(rs, rsSelected);

            }

        } catch (SQLException e) {
            throw new RuntimeException("Не удалось получить Квиток! " + e.getMessage());
        }

    }

    @Override
    public List<ITicket> get() {
        return null;
    }

    @Override
    public ITicket create(TicketDTO item) {
        return null;
    }

    @Override
    public ITicket update(long id, LocalDateTime dtUpdate, TicketDTO item) {
        return null;
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

    }

    private ITicket mapper(ResultSet rs, ResultSet rsSelected) throws SQLException {

        List<ISelectedItem> list = new ArrayList<>();

        while (rsSelected.next()){
            IPizzaInfo pizzaInfo = new PizzaInfo(rsSelected.getLong(8),
                    rsSelected.getObject(9, LocalDateTime.class),
                    rsSelected.getObject(10, LocalDateTime.class),
                    rsSelected.getString(11),
                    rsSelected.getString(12),
                    rsSelected.getInt(13));

            IMenuRow menuRow = new MenuRow(rsSelected.getLong(3),
                    rsSelected.getObject(4, LocalDateTime.class),
                    rsSelected.getObject(5, LocalDateTime.class),
                    pizzaInfo,
                    rsSelected.getDouble(6),
                    rsSelected.getLong(7));

            list.add(new SelectedItem(rsSelected.getLong(1),
                    menuRow,
                    rsSelected.getInt(2)));
        }

        if (rs.next()){
            IOrder order = new Order(rs.getLong(3),
                    rs.getObject(4, LocalDateTime.class),
                    rs.getObject(5, LocalDateTime.class),
                    list);

            return new Ticket(
                    String.valueOf(rs.getLong(1)),
                    rs.getObject(2, LocalDateTime.class),
                    order);

        }
        return null;
    }
}
