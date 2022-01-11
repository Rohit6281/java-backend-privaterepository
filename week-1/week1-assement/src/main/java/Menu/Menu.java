package Menu;

import java.util.Scanner;

public class Menu {
    private String prepareMenu() {
        String title = "\n --- Banking System ---";
        String m1 = "\n 1. Create New Account";
        String m2 = "\n 2. Show All Accounts";
        String m3 = "\n 3.Display balance ";
        String m4 = "\n 4. transfer money";
        String m5 = "\n 5. withdraw";
        String m6 = "\n 6. deposit";
        String m7 = "\n 7.activate acc";
        String m8 = "\n 8.Deactivate acc";
        String m9 = "\n 9. Exit";

        return title + m1 + m2 + m3 + m4 + m5 + m6 + m7 + m8 + m9;
    }

    public void showMenu() {
        var scanner = new Scanner(System.in);

        while (true) {
            System.out.println(prepareMenu());
            System.out.println(" *) enter the details : ");
            int ch = scanner.nextInt();


            if (ch == 9) System.exit(1);
            if (ch == 1) {
                System.out.println("Enter Account Number : ");
                int ac_Num = scanner.nextInt();

                System.out.println("Enter Balance : ");
                double amount = scanner.nextDouble();

                System.out.println("Enter Name : ");
                String ac_hl_nm = scanner.nextLine();



            }
            if(ch==2){
                System.out.println("Enter the acc_hl_nm");
                String ac_hl_nm=scanner.nextLine();
              //  service.showAllacc(ac_hl_nm);
            }
            if(ch==3){
                System.out.println("enter the ac_hl_nm");
                int amount=scanner.nextInt();
            }
            if(ch==4){
                System.out.println("enter the transfer acc num");
                int acc_num=scanner.nextInt();
            }
            if(ch==5){
                System.out.println("withdraw");
                int money=scanner.nextInt();
            }
        }
    }
}


