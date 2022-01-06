import db.Connectivity;
import service.DbService;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connectivity connectivity =new Connectivity();

        DbService service =new DbService(connectivity.getConnection());
      //  int cnt =service.create(6,
        //        "yyxz",
          //      Date.valueOf(LocalDate.now()),true);
        //if(cnt>0){
          //  System.out.println("employee created sucessfully");
            //service.find();
            //service.findEmployeeByName("pqr");
            service.txnDemo(60, "kol", Date.valueOf(LocalDate.now()), true, 100);
        }
    }

