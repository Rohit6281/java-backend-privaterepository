package BnkDbService;

import db.BankingConnection;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        BankingConnection connection= new BankingConnection();
        BnkService service= new BnkService(connection.getConnection());
     //    int cnt=service.createBnkAcc(1,500,"rohit", Date.valueOf(LocalDate.now()),true);
      //  int cnt1 =service.createBnkAcc(2,10000,"rn",Date.valueOf(LocalDate.now()),true);
//       if(cnt1>0){
//           System.out.println("Bnk created suceessfully");
//       }
     //   service.showAllAcc();
        service.checkBalance("rohit");
        service.checkBalance("rn");
    }

}
