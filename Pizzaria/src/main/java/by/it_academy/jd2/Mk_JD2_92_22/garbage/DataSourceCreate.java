package by.it_academy.jd2.Mk_JD2_92_22.garbage;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public class DataSourceCreate {
    private static  DataSourceCreate instance;
    private final ComboPooledDataSource cpds;

    public DataSourceCreate() throws IOException, SQLException, PropertyVetoException {
        cpds = new ComboPooledDataSource();
        cpds.setDriverClass("org.postgresql.Driver");
        cpds.setJdbcUrl("jdbc:postgresql://localhost:5432/company");
        cpds.setUser("postgres");
        cpds.setPassword("375256477485");
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(180);
    }

    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (instance==null){
            synchronized (DataSourceCreate.class){
                instance = new DataSourceCreate();
            }
        }
        return instance.cpds;
    }
}
