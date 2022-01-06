package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbService {
    private final Connection connection;

    public DbService(Connection connection) {
        this.connection = connection;
    }

    public int create(int empid, String empNm, Date dob, boolean isManager) throws SQLException {
        String sql = "insert into emp_info values(?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, empid);
        ps.setString(2, empNm);
        ps.setDate(3, dob);
        ps.setBoolean(4, isManager);

        int affected = ps.executeUpdate();
        return affected;

    }

    public int update() {
        return 0;
    }

    public int delete() {
        return 0;

    }

    public void find() {


    }
}
