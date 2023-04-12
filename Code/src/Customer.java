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
        int a = 0;
        do{
            Scanner scan = new Scanner(System.in);
            System.out.println("============================================");
            System.out.println("1. Buat Pesanan\n2. Lihat Pesanan\n3. Kembali ke login");
            System.out.print("Pilih Menu: ");
            try{
                int menu = scan.nextInt();
                switch(menu){
                    case 1:
                        System.out.println("buat pesanan\n");
                        break;
                    case 2:
                        System.out.println("lihat pesanan\n");
                        break;
                    case 3:
                        App.intro();
                    default:
                        System.out.println("tolong masukan input dengan benar");
                        a=1;
                }
            } catch(InputMismatchException e){
                System.out.println("masukan input dengan benar");
                a=1;
            }
            scan.close();
        }while(a == 1);
    }
}
