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
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        do{
            int i;
            System.out.println("============================================");
            System.out.println("1. Tambah Restaurant\n2. Lihat Restaurant\n3. Hapus Restaurant\n4. Kembali ke login");
            System.out.print("Pilih Menu: ");
            String input = scan.nextLine();
            switch(input){
                case "1":
                    System.out.print("masukin nama restoran => ");String nameRestaurant = scan.nextLine();
                    System.out.print("masukin alamat restoran => ");String addressRestaurant = scan.nextLine();
                    System.out.print("masukin menu restoran => ");String menuRestaurants = scan.nextLine();
                    Restaurant newRestaurant = new Restaurant(nameRestaurant, addressRestaurant, menuRestaurants);
                    restaurants.add(newRestaurant);
                    System.out.println("Restoran Berhasil Ditambah!");
                    break;
                case "2":
                    if(restaurants.get(0) != null){
                        System.out.println("All restaurants:");
                        i=1;
                        for (Restaurant restaurant : restaurants) {
                            System.out.printf("%d. %s%n",i,restaurant.toString());
                            i++;
                        }
                    }else{
                        System.out.println("Belum ada restaurant!");
                    }
                    break;
                case "3":
                    System.out.println("All restaurants:");
                    i=1;
                    for (Restaurant restaurant : restaurants) {
                        System.out.printf("%d. %s%n",i,restaurant.toString());
                        i++;
                    }
                    System.out.println("============================================");
                    System.out.print("Pilih restoran yang ingin dihapus: ");
                    int noRestaurant = scan.nextInt();
                    try{
                        restaurants.remove(noRestaurant-1);
                        System.out.println("Restoran berhasil dihapus"); 
                    } catch(IndexOutOfBoundsException e){
                        System.out.println("Restoran tidak ada");
                        break;
                    }
                    break;
                case "4":
                    App.intro();
                default:
                    System.out.println("tolong masukan input dengan benar");
                    break;
            }
        }while(true);
        
    }
}