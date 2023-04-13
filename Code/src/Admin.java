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
        do{
            int i=1;
            System.out.println("============================================");
            System.out.println("1. Tambah Restaurant\n2. Lihat Restaurant\n3. Hapus Restaurant\n4. Kembali ke login");
            System.out.print("Pilih Menu: ");
            String input = scan.nextLine();
            switch(input){
                case "1":
                    addRestaurant();
                    break;
                case "2":
                    Restaurant.showRestaurant();
                    break;
                case "3":
                    removeRestaurant();
                    break;
                case "4":
                    App.login();
                    return;
                default:
                    System.out.println("tolong masukan input dengan benar");
                    break;
            }
        }while(true);
    }

    public static void addRestaurant(){
        Scanner scan = new Scanner(System.in);
        System.out.print("masukin nama restoran => ");String nameRestaurant = scan.nextLine();
        System.out.print("masukin alamat restoran => ");String addressRestaurant = scan.nextLine();
        Restaurant restaurants = new Restaurant(nameRestaurant, addressRestaurant);
        System.out.println("Restoran Berhasil Ditambah!");
        int ulang, input;
        do{
            System.out.println("============================================");
            System.out.printf("Restoran %s%n",nameRestaurant);
            System.out.println("Tambah Menu : ");

            do{
                System.out.println("1. Tambah Makanan\n2. Tambah Minuman");   
                input = App.validInt();
                if(input<1 || input >2){
                    System.out.println("Input salah, bak ulang\n=> ");
                }
            }while(input<1 || input >2);

            System.out.print("masukan nama menu: "); String menuName = scan.nextLine();
            System.out.print("masukan harga menu: "); String menuPrice = Double.toString(App.validDouble());
            switch(input){
                case 1:
                    // System.out.println("MAKANANNN");
                    restaurants.addFood(menuName, menuPrice);
                    break;
                case 2:
                    // System.out.println("MINUMANNNN");
                    restaurants.addDrink(menuName, menuPrice);
                    break;
            }
            // System.out.println(Restaurant.getaArrayList());
            System.out.printf("%s%n%s%n%s%n",restaurants.getName(),restaurants.getAddress(),restaurants.getFoods());
            System.out.print("apakah anda ingin menambah menu lainnya?\n1. Ya\n2. Tidak\n"); 
            ulang = App.validInt();
            System.out.println(ulang);
        }while(ulang==1);
    }

    public static void removeRestaurant(){
        Scanner scan = new Scanner(System.in);
        System.out.println("All restaurants:");
        // System.out.println("============================================");
        Restaurant.showRestaurant();
        System.out.print("Pilih restoran yang ingin dihapus: ");
        int id = scan.nextInt();
        if(Restaurant.restaurants.size() == 0){
            Restaurant.removeRestaurant(id);
        }
        else{
            System.out.println("Restoran tidak ada");
        }
    }
}