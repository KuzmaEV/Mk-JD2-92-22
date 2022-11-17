package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IOrder;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.ISelectedItem;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.OrderDTO;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IOrderDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.MenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.Order;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.PizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.SelectedItem;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    private static final String GET_SQL = "SELECT \"order\".id, \"order\".dt_create, \"order\".dt_update,\n" +
            "selected_item.id, \"count\",\n" +
            "menu_row.id, menu_row.dt_create, menu_row.dt_update, price, menu,\n" +
            "info, pizza_info.dt_create, pizza_info.dt_update, name, description,\n" +
            "size\n" +
            " \n" +
            "\tFROM pizzeria.\"order\"\n" +
            "\tINNER JOIN pizzeria.selected_item ON \"order\".id = selected_item.\"order\"\n" +
            "\tINNER JOIN pizzeria.menu_row ON selected_item.menu_row = menu_row.id\n" +
            "\tINNER JOIN pizzeria.pizza_info ON menu_row.info = pizza_info.id;";
    private static final String CREATE_SQL = "";
    private static final String UPDATE_SQL = "";
    private static final String DELETE_SQL = "";

    public OrderDao(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public IOrder read(long id) {
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
    public List<IOrder> get() {
        return null;
    }

    @Override
    public IOrder create(OrderDTO item) {
        return null;
    }

    @Override
    public IOrder update(long id, LocalDateTime dtUpdate, OrderDTO item) {
        return null;
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

    }


    private IOrder mapper(ResultSet rs, ResultSet rsSelected) throws SQLException {

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
            return new Order(rs.getLong(1),
                    rs.getObject(2, LocalDateTime.class),
                    rs.getObject(3, LocalDateTime.class),
                    list);
        }
        return null;
    }
}
