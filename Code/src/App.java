import java.util.*;

public class App {
    static String username;
    static String pass;
    static int a = 0;
    String name, address, menu;
    public static void main(String[] args) throws Exception {
        login(); 
    }
    public static void login(){
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("========================================");
            System.out.println("Haloo selamat datang silahkan login duls");
            System.out.println("========================================");
            System.out.print("masukin user => ");String username = scan.nextLine();
            System.out.print("masukin pass => ");String pass = scan.nextLine();
            if(username.equals(Customer.getUserCustomer()) && pass.equals(Customer.getPassCustomer())){
                System.out.println("=========================================");
                System.out.println("HALO CUSTOMER");
                Customer.customerPage();
                a = 1;
            }
            else if(username.equals(Admin.getUserAdmin()) && pass.equals(Admin.getPassAdmin())){
                System.out.println("=========================================");
                System.out.println("HALO ADMIN");
                Admin.adminPage();
                a = 1;
            }
            else{
                System.out.println ("CREDENTIALS TIDAK SESUAI");
            }
        }while (a==0);
    }

    public static double validDouble(){
        double inp;
        Scanner scan = new Scanner(System.in);
        System.out.print("=> ");
        while(true){
            try{
                inp = scan.nextDouble();
                scan.nextLine();
                return inp;
                // break;
            }catch(InputMismatchException e){
                System.out.print("Input salah!, Ulang\n=>");
                scan.nextLine();
            }
        }
    }

    public static int validInt(){
        int inp;
        Scanner scan = new Scanner(System.in);
        System.out.print("=> ");
        while(true){
            try{
                inp = scan.nextInt();
                scan.nextLine();
                return inp;
                // break;
            }catch(InputMismatchException e){
                System.out.print("Input salah!, Ulang\n=>");
                scan.nextLine();
            }
        }
    }
}

