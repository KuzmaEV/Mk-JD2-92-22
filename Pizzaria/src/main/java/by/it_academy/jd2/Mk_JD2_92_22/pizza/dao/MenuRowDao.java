package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.DtoMenuRowService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IMenuRowDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.MenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.PizzaInfo;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MenuRowDao implements IMenuRowDao {

    private static final String SQL_CREATE = "INSERT INTO pizzeria.menu_row(\n" +
            "\tdt_create, dt_update, info, price, menu)\n" +
            "\tVALUES (?, ?, ?, ?, ?);";
    private static final String SQL_READ = "SELECT menu_row.id, menu_row.dt_create, menu_row.dt_update, price, menu,\n" +
            "info, pizza_info.dt_create, pizza_info.dt_update,name, description, size \n" +
            "\tFROM pizzeria.menu_row \n" +
            "\tJOIN pizzeria.pizza_info ON menu_row.info = pizza_info.id\n" +
            "\tWHERE menu_row.id = ?;";
    private static final String SQL_GET = "SELECT menu_row.id, menu_row.dt_create, menu_row.dt_update, price, menu,\n" +
            "info, pizza_info.dt_create, pizza_info.dt_update,name, description, size \n" +
            "\tFROM pizzeria.menu_row \n" +
            "\tJOIN pizzeria.pizza_info ON menu_row.info = pizza_info.id;";
    private static final String SQL_UPDATE = "UPDATE pizzeria.menu_row\n" +
            "\tSET dt_update=?, info=?, price=?, menu=?\n" +
            "\tWHERE id = ? AND dt_update = ?;";
    private static final String SQL_DELETE = "DELETE FROM pizzeria.menu_row\n" +
            "\tWHERE id = ? AND dt_update = ?;";

    private final DataSource ds;

    public MenuRowDao(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public IMenuRow read(long id) {
        try(Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_READ)) {

            ps.setLong(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return mapper(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Такой пункт меню не найден! " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<IMenuRow> get() {
        try(Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_GET)) {
            try(ResultSet resultSet = ps.executeQuery()){
                return mapperList(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException("При запросе данных произошла ошибка! " + e.getMessage());
        }
    }

    @Override
    public IMenuRow create(DtoMenuRowService item) {

        try(Connection conn = ds.getConnection();
            final PreparedStatement ps = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS)){

            ps.setObject(1, item.getDtUpdate());
            ps.setObject(2, item.getDtUpdate());
            ps.setLong(3, item.getInfo());
            ps.setDouble(4, item.getPrice());
            ps.setLong(5, item.getMenu());

            ps.execute();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long id = generatedKeys.getLong(1);
                    return read(id);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("При сохранении данных произашла ошибка! " + e.getMessage());
        }
        return null;
    }

    @Override
    public IMenuRow update(long id, LocalDateTime dtUpdate, DtoMenuRowService item) {

        try(Connection connection = ds.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE)) {

            ps.setObject(1, item.getDtUpdate());
            ps.setLong(2, item.getInfo());
            ps.setDouble(3, item.getPrice());
            ps.setLong(4,item.getMenu());

            ps.setLong(5, id);
            ps.setObject(6, dtUpdate);

            int countUpdatedRows = ps.executeUpdate();

            if (countUpdatedRows != 1){
                if (countUpdatedRows == 0){
                    throw new IllegalArgumentException("Не смогли обнавить запись!");
                } else {
                    throw new IllegalArgumentException("Обнавилось несколько записей");
                }
            }
            return read(id);

        } catch (SQLException e) {
            throw new RuntimeException("Не получилось обнавить данные! " + e.getMessage());
        }

    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {
        try(Connection connection = ds.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE)) {

            ps.setLong(1, id);
            ps.setObject(2, dtUpdate);

            int countDeletedRows = ps.executeUpdate();
            if (countDeletedRows !=1 ){
                if (countDeletedRows == 0){
                    throw new IllegalArgumentException("Не получилось удалить!");
                } else {
                    throw new IllegalArgumentException(" Удалили несколько записей!");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Не получилось удалить данные! " + e.getMessage());
        }

    }


    public IMenuRow mapper(ResultSet rs) {

        IPizzaInfo pizzaInfo;
        try {
            pizzaInfo = new PizzaInfo(rs.getLong(6),
                    rs.getObject(7, LocalDateTime.class),
                    rs.getObject(8, LocalDateTime.class),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getInt(11));
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка в мапере при создании пиццы! " + e.getMessage());
        }

        try {
            return new MenuRow(rs.getLong(1),
                    rs.getObject(2, LocalDateTime.class),
                    rs.getObject(3, LocalDateTime.class),
                    pizzaInfo,
                    rs.getDouble(4),
                    rs.getLong(5));
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка в мапере при создании menuRow! " + e.getMessage());
        }
    }

    public List<IMenuRow> mapperList(ResultSet rs) throws SQLException {
        List<IMenuRow> list = new ArrayList<>();
        while (rs.next()){
            list.add(mapper(rs));
        }
        return list;
    }

}
