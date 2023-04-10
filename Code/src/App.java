import java.util.*;

public class App {
    static String username;
    static String pass;
    static int a = 0;
    public static void main(String[] args) throws Exception {
        intro();
    }
    public static void intro(){
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("============================================");
            System.out.println("Haloooo selamat datang silahkan login dulsss");
            System.out.println("============================================");
            System.out.print("masukin user => ");String username = scan.nextLine();
            System.out.print("masukin pass => ");String pass = scan.nextLine();
            if(username.equals(Customer.getUserCustomer()) && pass.equals(Customer.getPassCustomer())){
                System.out.println("============================================");
                System.out.println("HALO CUSTOMER");
                a = 1;
            }
            else if(username.equals(Admin.getUserAdmin()) && pass.equals(Admin.getPassAdmin())){
                System.out.println("============================================");
                System.out.println("HALO ADMIN");
                a = 1;
            }
            else{
                System.out.println("CREDENTIALS TIDAK SESUAI");
            }
        }while (a==0);
        scan.close();
    }
}

