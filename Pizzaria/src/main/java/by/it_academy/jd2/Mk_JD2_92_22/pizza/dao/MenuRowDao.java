package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.DtoMenuRowService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IMenuRowDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.MenuRow;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MenuRowDao implements IMenuRowDao {

    private static final String SQL_CREATE = "INSERT INTO pizzeria.menu_row(\n" +
            "\tdt_create, dt_update, info, price)\n" +
            "\tVALUES (?, ?, ?, ?);";
    private static final String SQL_READ = "SELECT id, dt_create, dt_update, info, price, menu\n" +
            "\tFROM pizzeria.menu_row" +
            "WHERE id = ?;";
    private static final String SQL_GET = "SELECT id, dt_create, dt_update, info, price, menu\n" +
            "\tFROM pizzeria.menu_row;";
    private static final String SQL_UPDATE = "UPDATE pizzeria.menu_row\n" +
            "\tdt_update=?, info=?, price=?\n" +
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
            throw new RuntimeException("Такой пункт меню не найден", e);
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
            throw new RuntimeException("При запросе данных произошла ошибка", e);
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

            ps.execute();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return mapper(generatedKeys);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("При сохранении данных произашла ошибка", e);
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

            ps.setLong(4, id);
            ps.setObject(5, dtUpdate);

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
            throw new RuntimeException("Не получилось обнавить данные!");
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
            e.printStackTrace();
        }

    }

    public static IMenuRow mapper(ResultSet rs) throws SQLException {
        return new MenuRow(rs.getLong("id"),
                rs.getObject(2, LocalDateTime.class),
                rs.getObject(3, LocalDateTime.class),
                rs.getObject(4, IPizzaInfo.class),
                rs.getDouble(5));
        }

    public static List<IMenuRow> mapperList(ResultSet rs) throws SQLException {
        List<IMenuRow> list = new ArrayList<>();
        while (rs.next()){
            list.add(mapper(rs));
        }
        return list;
    }

}
