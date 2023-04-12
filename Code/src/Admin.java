import java.util.*;

public class Admin {
    private static String username = "admin";
    private static String password = "admin";
    
    public static String getUserAdmin(){
        return username;
    }
    public static String getPassAdmin(){
        return password;
    }

    public static void adminPage(){
        int a = 0;
        do{
            Scanner scan = new Scanner(System.in);
            System.out.println("============================================");
            System.out.println("1. Tambah Restaurant\n2. Lihat Restaurant\n3. Hapus Restaurant\n4. Kembali ke login");
            System.out.print("Pilih Menu: ");
            try{
                int menu = scan.nextInt();
                switch(menu){
                    case 1:
                        System.out.println("tambah");
                        break;
                    case 2:
                        System.out.println("lihat");
                        break;
                    case 3:
                        System.out.println("hapus");
                        break;
                    case 4:
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




// Scanner scan = new Scanner(System.in);
    // System.out.print("masukin nama restoran => "); String name = scan.nextLine();
    // System.out.print("masukin alamat restoran => ");String address = scan.nextLine();
    // System.out.print("masukin menu restoran => ");String menu = scan.nextLine();
    // Restaurant restaurant1 = new Restaurant(name, address, menu);
    // scan.close();
    // System.out.printf("Nama Restoran = %s%nAlamat Restoran = %s%nMenu = %s%n",restaurant1.getName(),restaurant1.getAddress(),restaurant1.getMenu());