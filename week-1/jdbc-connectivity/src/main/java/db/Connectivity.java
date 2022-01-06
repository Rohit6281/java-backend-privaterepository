package db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class Connectivity {
    private final Connection connection;

    public Connectivity() throws ClassNotFoundException, SQLException {
        forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_training_db", "root", "password");
        connection.setAutoCommit(false);
        System.out.println("conected to mysql sucessfully");
    }

    public Connection getConnection() {
        return connection;
    }

}
