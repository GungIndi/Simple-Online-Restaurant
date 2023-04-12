import java.util.*;

public class App {
    static String username;
    static String pass;
    static int a = 0;
    String name, address, menu;
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
                Customer.customerPage();
                a = 1;
            }
            else if(username.equals(Admin.getUserAdmin()) && pass.equals(Admin.getPassAdmin())){
                System.out.println("============================================");
                System.out.println("HALO ADMIN");
                Admin.adminPage();
                a = 1;
            }
            else{
                System.out.println ("CREDENTIALS TIDAK SESUAI");
            }
        }while (a==0);
        scan.close();
    }

    
    // System.out.print("masukin nama restoran => ");String nameRestaurant = scan.nextLine();
    // System.out.print("masukin alamat restoran => ");String addressRestaurantp = scan.nextLine();
    // System.out.print("masukin menu restoran => ");String menuRestaurants = scan.nextLine();
    // Restaurant restaurant1 = new Restaurant(name, address, menu);
}

