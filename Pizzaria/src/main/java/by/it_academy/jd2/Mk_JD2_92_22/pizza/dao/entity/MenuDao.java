package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenu;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.DtoMenuService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IMenuDao;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MenuDao implements IMenuDao {

    private final DataSource ds;

    private static final String READ_SQL = "SELECT id, dt_create, dt_update, name, enable\n" +
            "\tFROM pizzeria.menu\n" +
            "\tWHERE id = ?;";
    private static final  String GET_SQL = "SELECT id, dt_create, dt_update, name, enable\n" +
            "\tFROM pizzeria.menu;";
    private static final String CREATE_SQL = "INSERT INTO pizzeria.menu(\n" +
            "\tdt_create, dt_update, name, enable)\n" +
            "\tVALUES (?, ?, ?, ?);";
    private static final String UPDATE_SQL = "UPDATE pizzeria.menu\n" +
            "\tSET dt_update=?, name=?, enable=?\n" +
            "\tWHERE id = ? AND dt_update=?;";
    private static final String DELETE_SQL = "DELETE FROM pizzeria.menu\n" +
            "\tWHERE id = ? AND dt_update=?;";

    public MenuDao(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public IMenu read(long id) {
        try(Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(READ_SQL)) {

            ps.setLong(1, id);
            try(ResultSet resultSet = ps.executeQuery()){
                if (resultSet.next()){
                    return mapper(resultSet);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException("При запросе Меню возникла ошибка" + e.getMessage());
        }
        return null;
    }

    @Override
    public List<IMenu> get() {
        try(Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(GET_SQL)) {

            try(ResultSet resultSet = ps.executeQuery()){
                return mapperList(resultSet);
            }

        } catch (SQLException e) {
            throw new RuntimeException("При запросе данных возникла ошибка" + e.getMessage());
        }

    }

    @Override
    public IMenu create(DtoMenuService item) {

        try(Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(CREATE_SQL, Statement.RETURN_GENERATED_KEYS)) {

            ps.setObject(1, item.getDtUpdate());
            ps.setObject(2, item.getDtUpdate());
            ps.setString(3, item.getName());
            ps.setBoolean(4, item.isEnabled());

            ps.execute();


                try(ResultSet generatedKeys = ps.getGeneratedKeys()){
                    if (generatedKeys.next()){
                        return mapper(generatedKeys);
                    }
                }


        } catch (SQLException e) {
            throw new RuntimeException("При создании Меню возникла ошибка" + e.getMessage());
        }

        return null;
    }

    @Override
    public IMenu update(long id, LocalDateTime dtUpdate, DtoMenuService item) {

        try(Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_SQL, Statement.RETURN_GENERATED_KEYS)) {

            ps.setObject(1, item.getDtUpdate());
            ps.setString(2, item.getName());
            ps.setBoolean(3, item.isEnabled());

            ps.setLong(4, id);
            ps.setObject(5, dtUpdate);

            int countUpdateRow = ps.executeUpdate();

            if (countUpdateRow != 1){
                if (countUpdateRow == 0){
                    throw new RuntimeException("Не удалось обновить запись!");
                }
            } else {
                throw new RuntimeException("Обновило несколько записей!");
            }
            try(ResultSet generatedKeys = ps.getGeneratedKeys()){
                if (generatedKeys.next()){
                    return mapper(generatedKeys);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("При обнавлении данных возникла ошибка" + e.getMessage());
        }

        return null;
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

        try(Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {

            ps.setLong(1, id);
            ps.setObject(2, dtUpdate);

            int countDeletedRow = ps.executeUpdate();

            if (countDeletedRow != 1){
                if (countDeletedRow == 0){
                    throw new RuntimeException("Не удалось удалить запись!");
                } else {
                    throw new RuntimeException("Удалило больше одной записи!");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("При удалении Меню возникла ошибка" + e.getMessage());
        }

    }

    private static IMenu mapper(ResultSet rs) throws SQLException {
        List<IMenuRow> items = new ArrayList<>();

        return new Menu(rs.getLong(1),
                rs.getObject(2, LocalDateTime.class),
                rs.getObject(3, LocalDateTime.class),
                rs.getString(4),
                items,
                rs.getBoolean(5));
    }

    private static List<IMenu> mapperList(ResultSet rs) throws SQLException {
        List<IMenu> menuList = new ArrayList<>();

        while (rs.next()){
            menuList.add(mapper(rs));
        }
        return menuList;
    }
}
