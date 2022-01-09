package BnkDbService;

import com.mysql.cj.jdbc.result.ResultSetImpl;

import java.sql.*;

public class BnkService {
    private final Connection connection;

    public BnkService(Connection connection) {
        this.connection = connection;
    }

    public int createBnkAcc(int ac_num, int amount, String ac_hl_nm, Date ac_cre_dt, boolean status) throws SQLException {
        String sql = "insert into Bnk_info values(?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, ac_num);
        ps.setInt(2, amount);
        ps.setString(3, ac_hl_nm);
        ps.setDate(4, ac_cre_dt);
        ps.setBoolean(5, status);

        int affected = ps.executeUpdate();
        connection.commit();
        return affected;
    }

    public void showAllAcc() throws SQLException {
        String sql1 = " select * from Bnk_info";
        PreparedStatement ps1 = connection.prepareStatement(sql1);
        ResultSet rs = ps1.executeQuery();

        while ((rs.next())) {
            int ac_num = rs.getInt("ac_num");
            int amount = rs.getInt("amount");
            String ac_hl_nm = rs.getString("ac_hl_nm");
            Date ac_cre_dt = rs.getDate("ac_cre_dt");
            boolean status = rs.getBoolean("status");
            System.out.println("ac_num : " + ac_num + "amount : " + amount + "ac_hl_nm : " + "ac_cre_dt : " + "status : " + status);

        }

    }

    public void checkBalance(String ac_hl_nm) throws SQLException {
        String sql2 = "select ac_num from Bnk_info where ac_hl_nm=?";
        PreparedStatement ps3 = connection.prepareStatement(sql2);
        ps3.setString(1, ac_hl_nm);
        ResultSet rs1 = ps3.executeQuery();
        while ((rs1.next())) {
            int ac_num = rs1.getInt("ac_num");
            System.out.println("ac_num : " + ac_num);
        }
        connection.commit();
    }

    public void transferMoney(String ac_hl_nm, int amount) throws SQLException {
        String sql3 = " update Bnk_info set amount =? where ac_hl_nm=?";
        PreparedStatement ps4 = connection.prepareStatement(sql3);
        ps4.setInt(1, amount);
        ps4.setString(2, ac_hl_nm);

        var affected = ps4.executeUpdate();

        var sql4 = "update Bnk_info set amount =? where ac_hl_nm=?";
        PreparedStatement ps5 = connection.prepareStatement(sql4);
        ps5.setInt(1, amount);
        ps5.setString(2, ac_hl_nm);

        System.out.println("affected :" + affected);
        if (affected == 0) connection.rollback();
        connection.commit();
    }

    public int deposit(int amount, int ac_num) throws SQLException {
        String sql5 = "update Bnk_info set amount = amount-? where ac_num=?";
        PreparedStatement ps6 = connection.prepareStatement(sql5);
        ps6.setInt(1, amount);
        ps6.setInt(2, ac_num);


        int affected = ps6.executeUpdate();
        System.out.println("amount withdrawen");
        connection.commit();
        return affected;

    }

    public void withdraMoney(String ac_hl_nm) throws SQLException {
        String sql7 = "select amount from Bnk_info where ac_hl_nm=?";
        PreparedStatement ps7 = connection.prepareStatement(sql7);
        ps7.setString(1, ac_hl_nm);

        ResultSet rs5 = ps7.executeQuery();
        while (rs5.next()) {
            int amount = rs5.getInt("amount");
            System.out.println("amount : " + amount);

        }
        connection.commit();
    }

    public void Deactivate(String acc, boolean stat) throws SQLException {
        String sql8 = "update Bnk_info set status=? where ac_hl_nm=?";
        PreparedStatement ps8 = connection.prepareStatement(sql8);
        ps8.setString(2, acc);
        ps8.setBoolean(1, stat);
        var aff = ps8.executeUpdate();
        System.out.println("updated");

        connection.commit();

    }

    public void reActivate(String acc, boolean st) throws SQLException {
        String sql9 = "update Bnk_info set status=? where ac_hl_nm=?";
        PreparedStatement ps9 = connection.prepareStatement(sql9);
        ps9.setBoolean(1, st);
        ps9.setString(2, acc);
        var affe = ps9.executeUpdate();
        System.out.println("reactivated");
        connection.commit();

    }

}
