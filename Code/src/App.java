import java.util.*;

public class App {
    String username;
    String pass;
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Haloooo selamat datang silahkan login dulsss");
        System.out.println("masukin user");String username = scan.nextLine();
        System.out.println("masukin pass");String pass = scan.nextLine();
        if(username.equals(Customer.username) && pass.equals(Customer.password)){
            System.out.println("HALO CUSTOMER");
        }
        else if(username.equals(Admin.username) && pass.equals(Admin.password)){
            System.out.println("HALO ADMIN");
        }
        else{
            System.out.println("CREDENTIALS TIDAK SESUAI");
        }
    }
}

