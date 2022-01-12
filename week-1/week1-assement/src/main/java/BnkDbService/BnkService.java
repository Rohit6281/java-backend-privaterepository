package BnkDbService;

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
        String sql1 = " select * from Bnk_info ";
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
        String sql2 = "select amount from Bnk_info where ac_hl_nm=?";
        PreparedStatement ps3 = connection.prepareStatement(sql2);
        ps3.setString(1, ac_hl_nm);
        ResultSet rs1 = ps3.executeQuery();
        while ((rs1.next())) {
            int amount = rs1.getInt("amount");
            System.out.println("amount : " + amount);
        }
        connection.commit();
    }


    public int Transfer(int amt,int id,int id2) throws SQLException {
        String sql1="update Bnk_info set amount=amount- ? where ac_num=?";
        String sql2="update Bnk_info set amount=amount+ ? where ac_num=?";
        PreparedStatement ps1=connection.prepareStatement(sql1);
        PreparedStatement ps2= connection.prepareStatement(sql2);
        ps1.setInt(1,amt);
        ps1.setInt(2,id);

        ps2.setInt(1,amt);
        ps2.setInt(2,id2);
        int aff=ps1.executeUpdate();
        int aff1= ps2.executeUpdate();
        System.out.println("amount transfered");
        connection.commit();
          return aff;
    }

    public int deposit(int amount, int ac_num) throws SQLException {
        String sql5 = "update Bnk_info set amount =amount+ ? where ac_num=?";
        PreparedStatement ps6 = connection.prepareStatement(sql5);
        ps6.setInt(1, amount);
        ps6.setInt(2, ac_num);


        int affected = ps6.executeUpdate();
        System.out.println("amount deposited :" + amount);
        connection.commit();
        return affected;

    }

    public void withdraMoney(int amt, int id) throws SQLException {
        String sql7 = "update Bnk_info set amount=amount-? where ac_num=?";
        PreparedStatement ps7 = connection.prepareStatement(sql7);
        ps7.setInt(1, amt);
        ps7.setInt(2, id);
        ps7.executeUpdate();

        connection.commit();
        System.out.println("withdrawen : " + amt);

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

    public void activate(String acc, boolean sat) throws SQLException {
        String s11 = "update Bnk_info status=? where ac_hl_nm=?";
        PreparedStatement ps9 = connection.prepareStatement(s11);
        ps9.setString(2, acc);
        ps9.setBoolean(1, sat);
        ps9.executeUpdate();
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
