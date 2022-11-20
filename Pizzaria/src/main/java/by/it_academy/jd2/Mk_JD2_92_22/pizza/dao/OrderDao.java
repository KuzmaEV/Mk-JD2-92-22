package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.*;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.OrderDTO;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IOrderDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.*;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements IOrderDao {

    private final DataSource ds;

    private static final String READ_ORDER_SQL = "SELECT id, dt_create, dt_update\n" +
            "\tFROM pizzeria.\"order\"\n" +
            "            WHERE id = ?;";

    private static final String READ_SELECTED_SQL = "SELECT selected_item.id, \"count\",\n" +
            "menu_row.id, menu_row.dt_create, menu_row.dt_update, price, menu,\n" +
            "info, pizza_info.dt_create, pizza_info.dt_update, name, description,\n" +
            "size \n" +
            "FROM pizzeria.\"order\"\n" +
            "INNER JOIN pizzeria.selected_item ON \"order\".id = selected_item.\"order\"\n" +
            "INNER JOIN pizzeria.menu_row ON selected_item.menu_row = menu_row.id\n" +
            "INNER JOIN pizzeria.pizza_info ON menu_row.info = pizza_info.id\n" +
            "WHERE \"order\".id = ?;";

    private static final String GET_ORDER_SQL = "SELECT id, dt_create, dt_update\n" +
            "\tFROM pizzeria.\"order\"";
    private static final String GET_SELECTED_SQL = "SELECT selected_item.id, \"count\",\n" +
            "menu_row.id, menu_row.dt_create, menu_row.dt_update, price, menu,\n" +
            "info, pizza_info.dt_create, pizza_info.dt_update, name, description,\n" +
            "size \n" +
            "FROM pizzeria.\"order\"\n" +
            "INNER JOIN pizzeria.selected_item ON \"order\".id = selected_item.\"order\"\n" +
            "INNER JOIN pizzeria.menu_row ON selected_item.menu_row = menu_row.id\n" +
            "INNER JOIN pizzeria.pizza_info ON menu_row.info = pizza_info.id" +
            "WHERE \"order\".id = ?;";

    private static final String CREATE_ORDER_SQL = "INSERT INTO pizzeria.\"order\"(\n" +
            "\tdt_create, dt_update)\n" +
            "\tVALUES (?, ?);";
    private static final String CREATE_SELECTED_SQL = "INSERT INTO pizzeria.selected_item(\n" +
            "\tmenu_row, count, \"order\")\n" +
            "\tVALUES (?, ?, ?);";
    private static final String CREATE_TICKET_SQL = "INSERT INTO pizzeria.ticket(\n" +
            "\tdt_create, \"order\")\n" +
            "\tVALUES (?, ? );";

    private static final String UPDATE_SQL = "";
    private static final String DELETE_SQL = "DELETE FROM pizzeria.\"order\"\n" +
            "INNER JOIN pizzeria.selected_item ON \"order\".id = selected_item.\"order\"\n" +
            "INNER JOIN pizzeria.ticket ON \"order\".id = ticket.\"order\"\n" +
            "\tWHERE \"order\".id = ? AND dt_update = ?;";

    public OrderDao(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public ITicket read(long id) {
        try(Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(READ_ORDER_SQL);
            PreparedStatement psSelected = conn.prepareStatement(READ_SELECTED_SQL)) {

            ps.setLong(1, id);
            psSelected.setLong(1, id);

            try (ResultSet rs = ps.executeQuery();
            ResultSet rsSelected = psSelected.executeQuery()) {

                return mapper(rs, rsSelected);
            }



        } catch (SQLException e) {
            throw new RuntimeException("Не удалось получить заказ! " + e.getMessage());
        }
    }

    @Override
    public List<ITicket> get() {
        List<ITicket> orders = new ArrayList<>();
        try(Connection conn = ds.getConnection();
            PreparedStatement psOrder = conn.prepareStatement(GET_ORDER_SQL);
            PreparedStatement psSelected = conn.prepareStatement(GET_SELECTED_SQL)) {

            try (ResultSet rsOrder = psOrder.executeQuery()){
                while (rsOrder.next()){
                    rsOrder.getLong(1);
                    try(ResultSet rsSelected = psSelected.executeQuery()){

                        orders.add(mapper(rsOrder, rsSelected));
                    }
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException("Не удалось получить спимок заказов! " + e.getMessage());
        }

        return orders;
    }

    @Override
    public ITicket create(OrderDTO item) {
        try(Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(CREATE_ORDER_SQL, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement psSelected = conn.prepareStatement(CREATE_SELECTED_SQL);
            PreparedStatement psTicket = conn.prepareStatement(CREATE_TICKET_SQL)) {

            conn.setAutoCommit(false);  //Отключаем автоКоммит

            ps.setObject(1, item.getDtUpdate());
            ps.setObject(2, item.getDtUpdate());

            ps.execute();
            try (ResultSet gk = ps.getGeneratedKeys()){
                if (gk.next()){
                    long id = gk.getLong(1);

                    psTicket.setObject(1, gk.getObject(2, LocalDateTime.class));
                    psTicket.setLong(2, id);
                    psTicket.execute();

                    for (OrderDTO.Selected selected : item.getSelectedItem()) {
                        psSelected.setLong(1, selected.getMenuRow());
                        psSelected.setInt(2, selected.getCount());
                        psSelected.setLong(3, id);

                        psSelected.addBatch();
                    }
                    psSelected.executeBatch();

                    conn.commit();

                    return read(id);
                }

            }


        } catch (SQLException e) {
            throw new RuntimeException("Не получилось сдалоть заказ! " + e.getMessage());
        }
        return null;
    }

    @Override
    public ITicket update(long id, LocalDateTime dtUpdate, OrderDTO item) {
        return null;
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

        try(Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
            ps.setLong(1, id);
            ps.setObject(2, dtUpdate);

            int countDeletedRows = ps.executeUpdate();
            if (countDeletedRows != 1){
                if (countDeletedRows == 0){
                    throw new IllegalArgumentException("Не удалось удалить!");
                } else {
                    throw new IllegalArgumentException("Ошибка. Удалило несколько заказов!");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Ну удалось удалить заказ! " + e.getMessage());
        }


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

        if (rs.next()) {
            IOrder order = new Order(rs.getLong(1),
                    rs.getObject(2, LocalDateTime.class),
                    rs.getObject(3, LocalDateTime.class),
                    list);

            return new Ticket(String.valueOf(order.getId()),
                    order.getDtCreate(),
                    order);
        }
        return null;
    }
}
