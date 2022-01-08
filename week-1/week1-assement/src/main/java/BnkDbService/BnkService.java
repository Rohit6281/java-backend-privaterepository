package BnkDbService;

import com.mysql.cj.jdbc.result.ResultSetImpl;

import java.sql.*;

public class BnkService {
    private  final Connection connection;

    public BnkService(Connection connection) {
        this.connection = connection;
    }
    public int createBnkAcc(int ac_num, int amount, String ac_hl_nm, Date ac_cre_dt, boolean status) throws SQLException {
        String sql = "insert into Bnk_info values(?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,ac_num);
        ps.setInt(2, amount);
        ps.setString(3,ac_hl_nm);
        ps.setDate(4,ac_cre_dt);
        ps.setBoolean(5,status);

        int affected =ps.executeUpdate();
        connection.commit();
        return affected;
    }
    public void showAllAcc() throws SQLException {
        String sql1=" select * from Bnk_info";
        PreparedStatement ps1=connection.prepareStatement(sql1);
        ResultSet rs=ps1.executeQuery();

        while((rs.next())){
            int ac_num = rs.getInt( "ac_num");
            int amount = rs.getInt("amount");
            String ac_hl_nm=rs.getString("ac_hl_nm");
           Date ac_cre_dt=rs.getDate("ac_cre_dt");
             boolean status=rs.getBoolean("status");
            System.out.println("ac_num : "+ac_num+"amount : "+amount+"ac_hl_nm : "+"ac_cre_dt : "+"status : "+status);

        }

    }
    public void checkBalance(String ac_hl_nm) throws SQLException {
        String sql2="select ac_num from Bnk_info where ac_hl_nm=?";
        PreparedStatement ps3= connection.prepareStatement(sql2);
        ps3.setString(1,ac_hl_nm);
        ResultSet rs1=ps3.executeQuery();
        while((rs1.next())){
            int ac_num= rs1.getInt("ac_num");
            System.out.println("ac_num : "+ac_num);
        }
    }
}
