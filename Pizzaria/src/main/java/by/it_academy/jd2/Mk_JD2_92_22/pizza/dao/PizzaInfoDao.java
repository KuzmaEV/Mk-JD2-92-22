package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IPizzaInfoDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.PizzaInfo;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PizzaInfoDao implements IPizzaInfoDao {

    private static final String CREATE_SQL = "INSERT INTO pizzeria.pizza_info(\n" +
            "\t dt_create, dt_update, name, description, size)\n" +
            "\t VALUES (?, ?, ?, ?, ?);";
    private static final String READ_BY_ID_SQL = "SELECT id, dt_create, dt_update, name, description, size\n" +
            "\tFROM pizzeria.pizza_info\n" +
            "\tWHERE id = ?;";
    private static final String READ_SQL = "SELECT id, dt_create, dt_update, name, description, size\n" +
            "\tFROM pizzeria.pizza_info;";
    private static final String UPDATE_SQL = "UPDATE pizzeria.pizza_info\n" +
            "\tSET dt_update=?, name=?, description=?, size=?\n" +
            "\tWHERE id = ? AND dt_update = ?;";
    private static final String DELETE_SQL = "DELETE FROM pizzeria.pizza_info\n" +
            "\tWHERE id = ? AND dt_update = ?;";

    private final DataSource ds;

    public PizzaInfoDao(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public IPizzaInfo read(long id) {
        try (Connection conn = DataSourceCreator.getInstance().getConnection();
             PreparedStatement smt = conn.prepareStatement(READ_BY_ID_SQL)){

            smt.setLong(1, id);

            try(ResultSet resultSet = smt.executeQuery()){
                if (resultSet.next()) {
                    return mapper(resultSet);
                }
            }
        } catch (PropertyVetoException | SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("При запросе данных произошла ошибка", e);
        }
        return null;
    }

    @Override
    public List<IPizzaInfo> get() {

        try(Connection conn = ds.getConnection();
            PreparedStatement stm = conn.prepareStatement(READ_SQL)){
            try (ResultSet resultSet = stm.executeQuery()){
                return mapperList(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException("При запросе данных произошла ошибка", e);
        }

    }

    @Override
    public IPizzaInfo create(IPizzaInfo item) {
        try (Connection conn = ds.getConnection();
            PreparedStatement stm = conn.prepareStatement(CREATE_SQL, Statement.RETURN_GENERATED_KEYS)){

            stm.setObject(1, item.getDtCreate());
            stm.setObject(2, item.getDtUpdate());
            stm.setString(3, item.getName());
            stm.setString(4, item.getDescription());
            stm.setInt(5, item.getSize());
            stm.execute();

            long id = -1;

            try (ResultSet generatedKeys = stm.getGeneratedKeys()){
                if (generatedKeys.next()){
                    id = generatedKeys.getLong(1);
                }
            }

            return read(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("При сохранении данных произошла ошибка", e);
        }
    }

    @Override
    public IPizzaInfo update(long id, LocalDateTime dtUpdate, IPizzaInfo item) {

        try (Connection conn = ds.getConnection();
             PreparedStatement stm = conn.prepareStatement(UPDATE_SQL)){
            stm.setObject(1, item.getDtUpdate());
            stm.setString(2, item.getName());
            stm.setString(3, item.getDescription());
            stm.setInt(4, item.getSize());

            stm.setLong(5, id);
            stm.setObject(6, dtUpdate);

            int countUpdatedRows = stm.executeUpdate();
            if (countUpdatedRows != 1){
                if (countUpdatedRows == 0){
                    throw new IllegalArgumentException( "Несмогли обновить запись!");
                }else {
                    throw new IllegalArgumentException("Обнавили более одной записи!");
                }
            }
            return read(id);

        } catch (SQLException e) {
            throw new RuntimeException("При изменении данных произошла ошибка ", e);
        }
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {
        try (Connection conn = ds.getConnection();
             PreparedStatement stm = conn.prepareStatement(DELETE_SQL)
        ){

            stm.setLong(1, id);
            stm.setObject(2, dtUpdate);

            final int countDeletedRows = stm.executeUpdate();
            if (countDeletedRows != 1){
                if (countDeletedRows == 0){
                    throw new IllegalArgumentException("Не смогли обновить запись!");
                }else {
                    throw new IllegalArgumentException("Обнавили более одной записи!");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("При удалении данных произошла ошибка", e);
        }

    }

    public IPizzaInfo mapper(ResultSet rs) throws SQLException {
        return new PizzaInfo(rs.getLong("id"),
                rs.getObject("dt_create", LocalDateTime.class),
                rs.getObject("dt_update", LocalDateTime.class),
                rs.getString("name"),
                rs.getString("description"),
                rs.getInt("size")
                );
    }
    public  List<IPizzaInfo> mapperList(ResultSet rs) throws SQLException {
        List<IPizzaInfo> list = new ArrayList<>();
        while (rs.next()){
            list.add(mapper(rs));
        }
        return list;
    }
}
