import BnkDbService.BnkService;
import Menu.Menu;
import db.BankingConnection;

import java.sql.SQLException;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Menu m = new Menu();
        m.showMenu();
    }
}
