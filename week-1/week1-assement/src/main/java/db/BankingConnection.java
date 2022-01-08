package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class BankingConnection {
    private final Connection connection;

    public BankingConnection()throws ClassNotFoundException, SQLException{
        forName("com.mysql.cj.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Bnk_acc", "root", "password");
        connection.setAutoCommit(false);
        System.out.println("connected to mysql");
    }

    public Connection getConnection() {
        return connection;
    }
}
