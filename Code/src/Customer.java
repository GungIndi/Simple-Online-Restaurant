import java.util.*;

public class Customer {
    private static String username = "customer";
    private static String password = "customer";
    
    public static String getUserCustomer(){
        return username;
    }
    public static String getPassCustomer(){
        return password;
    }

    public static void customerPage(){
        do{
            System.out.println("============================================");
            System.out.println("1. Buat Pesanan\n2. Lihat Pesanan\n3. Kembali ke login");
            System.out.print("Pilih Menu: ");
            int menu = App.validInt();
            switch(menu){
                case 1:
                    Restaurant.showMenu();
                    break;
                case 2:
                    System.out.println("lihat pesanan\n");
                    break;
                case 3:
                    App.login();
                    return;
                default:
                    System.out.println("tolong masukan input dengan benar");
                    break;
            }
        }while(true);
    }
}
