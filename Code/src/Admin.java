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
        Scanner scan = new Scanner(System.in);
        // App.clearScreen();
        do{
            System.out.println("\n\t==============================================");
            System.out.println("\t||               Welcome Admin!             ||");
            System.out.println("\t==============================================");
            System.out.println("\t1. Tambah Restaurant\n\t2. Lihat Restaurant\n\t3. Hapus Restaurant\n\t4. Kembali ke login");
            System.out.println("\t==============================================");
            System.out.print("\tPilih Menu: ");
            int input1 = App.validInt();
            switch(input1){
                case 1:
                    // App.clearScreen();
                    addRestaurant();
                    break;
                case 2:
                    Restaurant.showRestaurant();
                    System.out.print("\n\tPress enter to continue...\n\t");
                    scan.nextLine();
                    App.clearScreen();
                    break;
                case 3:
                    removeRestaurant();
                    System.out.print("\tPress enter to continue...\n\t");
                    scan.nextLine();
                    App.clearScreen();
                    break;
                case 4:
                    App.login();
                    return;
                default:
                    System.out.println("\tInput salah, Ulang");
                    App.clearScreen();
                    break;
            }
        }while(true);
    }

    public static void addRestaurant(){
        Scanner scan = new Scanner(System.in);
        // App.clearScreen();
        System.out.println("\t==============================================");
        System.out.print("\tMasukin Nama Restoran => ");String nameRestaurant = scan.nextLine();
        System.out.print("\tMasukin Alamat Restoran => ");String addressRestaurant = scan.nextLine();
        // System.out.println("\n\t==============================================");
        Restaurant restaurants = new Restaurant(nameRestaurant, addressRestaurant);  
        System.out.println("\tRestoran Berhasil Ditambah!");
        // System.out.println(restaurants.getName());
        int ulang, input;
        do{
            App.clearScreen();
            System.out.println("\t============================================");
            System.out.printf("\tRestoran %s%n",nameRestaurant);

            do{
            System.out.println("\t============================================");
            System.out.println("\tTambah Menu : ");

                System.out.println("\t1. Tambah Makanan\n\t2. Tambah Minuman");   
                input = App.validInt();
                if(input<1 || input >2){
                    App.clearScreen();
                    System.out.println("\tInput Salah, Ulangi");
                }
            }while(input<1 || input >2);

            System.out.print("\tMasukan Nama Menu: "); String menuName = scan.nextLine();
            System.out.print("\tMasukan Harga Menu: Rp."); String menuPrice = Double.toString(App.validDouble());
            switch(input){
                case 1:
                    restaurants.addFood(menuName, menuPrice);
                    break;
                case 2:
                    restaurants.addDrink(menuName, menuPrice);
                    break;
            }
            App.clearScreen();
            do{
                System.out.println("\t============================================");
                System.out.print("\tApakah anda ingin menambah menu lainnya?\n\t1. Ya\n\t2. Tidak\n");  
                    ulang = App.validInt();
                    if(ulang<1 || ulang >2){
                        App.clearScreen();
                        System.out.println("\tInput Salah, Ulangi");
                    }
            }while(ulang<1 || ulang >2);
        }while(ulang==1);
        Restaurant.addRestaurant(restaurants);
        App.clearScreen();
    }

    public static void removeRestaurant(){
        App.clearScreen();
        if(Restaurant.showRestaurant() != 0){
            System.out.println("\n\t==============================================");
            System.out.print("\tPilih restoran yang ingin dihapus: ");
            int id = App.validInt();
            Restaurant.removeRestaurant(id);
            System.out.println("\n\t==============================================");
            System.out.println("\tRestaurant Berhasil Dihapus!");
        }
        else{
            System.out.println("\tSilahkan menambah restoran terlebih dahulu!\n");
            return;
        }
    }
}