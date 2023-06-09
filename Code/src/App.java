import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        login(); 
    }
    public static void login(){
        Scanner scan = new Scanner(System.in);
        App.clearScreen();
        System.out.println("\n\t==============================================");
        System.out.println("\t||                                          ||");
        System.out.println("\t|| Haloo selamat datang silahkan login dulu ||");
        System.out.println("\t||                                          ||");
        System.out.println("\t==============================================");
        int a=0;
        do{
            System.out.print("\tMasukin Username => ");String username = scan.nextLine();
            System.out.print("\tMasukin Password => ");String pass = scan.nextLine();
            if(username.equals(Customer.getUserCustomer()) && pass.equals(Customer.getPassCustomer())){
                App.clearScreen();
                Customer.customerPage();
                a = 1;
            }
            else if(username.equals(Admin.getUserAdmin()) && pass.equals(Admin.getPassAdmin())){
                App.clearScreen();
                Admin.adminPage();
                a = 1;
            }
            else{
                App.clearScreen();
                System.out.println("\n\t==============================================");
                System.out.println("\t||            Credentials Invalid!          ||");
                System.out.println("\t==============================================");
            }
        }while (a==0);
    }

    public static double validDouble(){
        double inp;
        Scanner scan = new Scanner(System.in);
        // System.out.print("\t=> ");
        while(true){
            try{
                inp = scan.nextDouble();
                scan.nextLine();
                return inp;
                // break;
            }catch(InputMismatchException e){
                System.out.print("\tInput salah!, Ulang\n\t=> ");
                scan.nextLine();
            }
        }
    }

    public static int validInt(){
        int inp;
        Scanner scan = new Scanner(System.in);
        System.out.print("\t=> ");
        while(true){
            try{
                inp = scan.nextInt();
                scan.nextLine();
                return inp;
                // break;
            }catch(InputMismatchException e){
                App.clearScreen();
                System.out.print("\tInput salah!, Ulang\n\t=> ");
                scan.nextLine();
            }
        }
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}

