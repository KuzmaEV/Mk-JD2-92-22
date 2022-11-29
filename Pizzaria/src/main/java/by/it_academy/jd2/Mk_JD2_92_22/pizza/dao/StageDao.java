package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IStage;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.core.Stage;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.dto.StageDTO;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.IStageDao;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StageDao implements IStageDao {
    private final DataSource dataSource;

    private static final String READ_SQL = "SELECT id, dt_create, dt_update, description\n" +
            "\tFROM pizzeria.stage" +
            "WHERE id = ?;";

    private static final String GET_SQL = "SELECT id, dt_create, dt_update, description\n" +
            "\tFROM pizzeria.stage;";

    private static final String CREATE_SQL = "INSERT INTO pizzeria.stage(\n" +
            "\tdt_create, dt_update, description)\n" +
            "\tVALUES (?, ?, ?);";

    private static final String UPDATE_SQL = "UPDATE pizzeria.stage\n" +
            "\tSET dt_update=?, description=?\n" +
            "\tWHERE id = ? AND dtUpdate = ?;";

    private static final String DELETE_SQL = "DELETE FROM pizzeria.stage\n" +
            "\tWHERE id = ? AND dtUpdate = ?;";

    public StageDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public IStage read(long id) {

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(READ_SQL)){

            ps.setLong(1, id);
            try(ResultSet resultSet = ps.executeQuery()){
                return mapper(resultSet);
            }

        } catch (SQLException e) {
           throw new RuntimeException( "Не удалось получить стадию заказа! " + e.getMessage());
        }


    }

    @Override
    public List<IStage> get() {

        List<IStage> stages = new ArrayList<>();
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(GET_SQL)){

            try(ResultSet resultSet = ps.executeQuery()){
                while (resultSet.next()) {
                    stages.add(mapper(resultSet));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException( "Не удалось получить стадии заказа! " + e.getMessage());
        }

        return stages;
    }

    @Override
    public IStage create(StageDTO item) {
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(CREATE_SQL, Statement.RETURN_GENERATED_KEYS)) {

            ps.setObject(1, item.getDtUpdate());
            ps.setObject(2, item.getDtUpdate());

            int countCreateRows = ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()){
                long id;
                if (generatedKeys.next()){
                    id = generatedKeys.getLong(1);
                    return read(id);
                }
            }



        } catch (SQLException e) {
            throw new RuntimeException("Не удалосьсаздать стадию заказа! " + e.getMessage());
        }
        return null;
    }

    @Override
    public IStage update(long id, LocalDateTime dtUpdate, StageDTO item) {
        return null;
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

    }

    private IStage mapper(ResultSet resultSet) throws SQLException {

        if (resultSet.next()){
            return new Stage(resultSet.getLong(1),
                    resultSet.getObject(2, LocalDateTime.class),
                    resultSet.getObject(3, LocalDateTime.class),
                    resultSet.getString(4));
        }
        return null;

    }
}
