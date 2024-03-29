package by.it_academy.jd2.Mk_JD2_92_22.garbage;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IMenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.ISelectedItem2;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.core.SelectedItem2;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.dto.DtoSelectedItemService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.MenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.PizzaInfo;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SelectedItemDao implements ISelectedItemDao {
    private final DataSource ds;

    private static final String READ_SQL = "SELECT selected_item.id, selected_item.dt_create, selected_item.dt_update, count,\n" +
            "menu_row.id, menu_row.dt_create, menu_row.dt_update, price, menu,\n" +
            "info, pizza_info.dt_create, pizza_info.dt_update,name, description, size\n" +
            "\tFROM pizzeria.selected_item" +
            "\tINNER JOIN pizzeria.menu_row ON menu_row.id = selected_item.row" +
            "\tINNER JOIN pizzeria.pizza_info ON menu_row.info = pizza_info.id" +
            "\tWHERE selected_item.id = ?;";

    private static final String GET_SQL = "SELECT selected_item.id, selected_item.dt_create, selected_item.dt_update, count,\n" +
            "menu_row.id, menu_row.dt_create, menu_row.dt_update, price, menu,\n" +
            "info, pizza_info.dt_create, pizza_info.dt_update,name, description, size\n" +
            "\tFROM pizzeria.selected_item" +
            "\tINNER JOIN pizzeria.menu_row ON menu_row.id = selected_item.row" +
            "\tINNER JOIN pizzeria.pizza_info ON menu_row.info = pizza_info.id";

    private static final String CREATE_SQL = "INSERT INTO pizzeria.selected_item(\n" +
            "\tdt_create, dt_update, row, count)\n" +
            "\tVALUES (?, ?, ?, ?);";

    private static final String UPDATE_SQL = "UPDATE pizzeria.selected_item\n" +
            "\tSET dt_update=?, row=?, count=?\n" +
            "\tWHERE id = ? AND dt_update = ?;";

    private static final String DELETE_SQL = "DELETE FROM pizzeria.selected_item\n" +
            "\tWHERE id = ? AND dt_update = ?;";

    public SelectedItemDao(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public ISelectedItem2 read(long id) {

        try(Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(READ_SQL)) {

            ps.setLong(1, id);

            try(ResultSet resultSet = ps.executeQuery()){
                if (resultSet.next()) {
                    return mapper(resultSet);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("! " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<ISelectedItem2> get() {

        try(Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(GET_SQL)) {

            try (ResultSet resultSet = ps.executeQuery()){
                List<ISelectedItem2> list = new ArrayList<>();
                while (resultSet.next()){
                    list.add(mapper(resultSet));
                }
                return list;
            }

        } catch (SQLException e) {
            throw new RuntimeException("! " + e.getMessage());
        }
    }

    @Override
    public ISelectedItem2 create(DtoSelectedItemService item) {

        try(Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(CREATE_SQL, Statement.RETURN_GENERATED_KEYS)) {

            ps.setObject(1, item.getDtUpdate());
            ps.setObject(2, item.getDtUpdate());
            ps.setLong(3, item.getMenuRow());
            ps.setInt(4, item.getCount());

            ps.execute();



            try(ResultSet gk = ps.getGeneratedKeys()){

                if (gk.next()){
                    return read(gk.getLong(1));
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException("! " + e.getMessage());
        }
        return null;

    }

    @Override
    public ISelectedItem2 update(long id, LocalDateTime dtUpdate, DtoSelectedItemService item) {

        try(Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_SQL, Statement.RETURN_GENERATED_KEYS)) {

            ps.setObject(1, item.getDtUpdate());
            ps.setLong(2, item.getMenuRow());
            ps.setInt(3, item.getCount());

            ps.setLong(4, id);
            ps.setObject(5, dtUpdate);

            int countUpdatedRows = ps.executeUpdate();

            if (countUpdatedRows != 1){
                if (countUpdatedRows == 0){
                    throw new RuntimeException("Не удалось обнавить запись!");
                } else {
                    throw new RuntimeException("Обнавилось несколько запписей!");
                }
            }

            try(ResultSet gk = ps.getGeneratedKeys()){
                if (gk.next()){
                    return read(gk.getLong(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("! " + e.getMessage());
        }
        return null;
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

        try(Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {

            ps.setLong(1, id);
            ps.setObject(2, dtUpdate);

            int countUpdatedRows = ps.executeUpdate();

            if (countUpdatedRows != 1){
                if (countUpdatedRows == 0){
                    throw new RuntimeException("Не удалось обнавить запись!");
                } else {
                    throw new RuntimeException("Обнавилось несколько запписей!");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("! " + e.getMessage());
        }
    }

    public static ISelectedItem2 mapper(ResultSet rs) throws SQLException {


        IMenuRow menuRow;
        IPizzaInfo pizzaInfo;
        try {
            pizzaInfo = new PizzaInfo(rs.getLong(10),
                    rs.getObject(11, LocalDateTime.class),
                    rs.getObject(12, LocalDateTime.class),
                    rs.getString(13),
                    rs.getString(14),
                    rs.getInt(15));
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка в мапере при создании пиццы! " + e.getMessage());
        }

        try {
            menuRow = new MenuRow(rs.getLong(5),
                    rs.getObject(6, LocalDateTime.class),
                    rs.getObject(7, LocalDateTime.class),
                    pizzaInfo,
                    rs.getDouble(8),
                    rs.getLong(9));
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка в мапере при создании menuRow! " + e.getMessage());
        }


        return new SelectedItem2(rs.getLong(1),
                rs.getObject(2, LocalDateTime.class),
                rs.getObject(3, LocalDateTime.class),
                menuRow,
                rs.getInt(4)
                );
        }

    }

