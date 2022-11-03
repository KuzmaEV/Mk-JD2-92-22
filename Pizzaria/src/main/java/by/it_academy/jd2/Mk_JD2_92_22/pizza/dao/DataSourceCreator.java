package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class DataSourceCreator {
    private static DataSourceCreator instance;
    private final ComboPooledDataSource cpdc;

    public DataSourceCreator() throws PropertyVetoException {
        cpdc = new ComboPooledDataSource();
        cpdc.setDriverClass("org.postgresql.Driver");
        cpdc.setJdbcUrl("jdbc:postgres://localhost:5432/company");
        cpdc.setUser("postgres");
        cpdc.setPassword("375256477485");
        cpdc.setMinPoolSize(5);
        cpdc.setAcquireIncrement(5);
        cpdc.setMinPoolSize(20);
        cpdc.setMaxStatements(180);
    }

    public static DataSource getInstance() throws PropertyVetoException {
        if (instance == null){
            synchronized (DataSourceCreator.class){
                instance = new  DataSourceCreator();
            }
        }

        return instance.cpdc;
    }
}
