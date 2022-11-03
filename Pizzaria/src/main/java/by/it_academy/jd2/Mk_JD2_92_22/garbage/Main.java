package by.it_academy.jd2.Mk_JD2_92_22.garbage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company",
                        "postgres", "375256477485");
                Statement stm = conn.createStatement();
                ResultSet resultSet = stm.executeQuery("SELECT id, name, job, dep\n" +
                        "FROM structure.emp")) {
            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {

                employees.add(map(resultSet));


            }
            System.out.println(employees);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Employee map(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getLong("id"));
        employee.setName(resultSet.getString("name"));
        long depRaw = resultSet.getLong("dep");
        if(depRaw != 0){
            employee.setDep(depRaw);
        }
        long jopRaw = resultSet.getLong("job");
        if (!resultSet.wasNull()){
            employee.setJob(jopRaw); // checking for NULL
        }
        return employee;
    }
}

