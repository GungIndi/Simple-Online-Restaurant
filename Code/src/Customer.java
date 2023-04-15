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
        do{
            System.out.println("============================================");
            System.out.println("1. Buat Pesanan\n2. Lihat Pesanan\n3. Kembali ke login");
            System.out.print("Pilih Menu: ");
            int menu = App.validInt();
            switch(menu){
                case 1:
                    addOrder();
                    break;
                case 2:
                    Order.showOrder();
                    break;
                case 3:
                    App.login();
                    return;
                default:
                    System.out.println("tolong masukan input dengan benar");
                    break;
            }
        }while(true);
    }

    public static void addOrder(){
        if(Restaurant.showRestaurant() != 0){
            int idRestaurant;
            do{   
                System.out.print("Pilih restoran yang ingin dipesan: ");
                idRestaurant = App.validInt();
                if(idRestaurant<1 || idRestaurant >Restaurant.restaurants.size()){
                    System.out.println("Input salah,coba ulangi\n=> ");
                }
            }while(idRestaurant<1 || idRestaurant >Restaurant.restaurants.size());
            
            ArrayList<ArrayList<String>> foods = new ArrayList<>();
            ArrayList<ArrayList<String>> drinks = new ArrayList<>();
            foods = Restaurant.restaurants.get(idRestaurant - 1).getFoods();
            drinks = Restaurant.restaurants.get(idRestaurant - 1).getDrinks();
            
            System.out.println("Masukan jenis menu yang akan dipesan\n1. Makanan\n2. Minuman");
            int jenisMenu = App.validInt();
            switch(jenisMenu){
                case 1:
                    System.out.printf("%n%s - %s %nMenu Makanan: %n",Restaurant.restaurants.get(idRestaurant - 1).getName(),Restaurant.restaurants.get(idRestaurant - 1).getAddress());
                    if(foods.size() == 0){
                        System.out.println("tidak ada makanan");
                    }else{
                        int idFood = 1;
                        for(ArrayList<String> food : Restaurant.restaurants.get(idRestaurant-1).getFoods()){
                            System.out.printf("%d. %s\tRp. %s\n", idFood, food.get(0),food.get(1));
                            idFood++;
                        }
                        int idMenu, totalOrder=0;
                        System.out.println("Masukan id menu yang akan dipesan");
                        do{
                            idMenu = App.validInt();
                            if(idMenu<1 || idMenu >Restaurant.foods.size()){
                                System.out.println("Input salah,coba ulangi\n=> ");
                            }
                        }while(idMenu<1 || idMenu >Restaurant.foods.size());

                        System.out.println("jumlah pesanan");
                        do{
                            totalOrder = App.validInt();
                            if(totalOrder == 0){
                                System.out.println("masukan jumlah dengan benar!\n");
                            }
                        }while(totalOrder == 0);
                        System.out.println(("Apakah ingin memesan menu lain?"));
                        System.out.println("masukan jarak: ");
                        double distance = App.validDouble();
                        Order.addOrder(new Order(
                            idRestaurant,                            
                            idMenu, 
                            Restaurant.restaurants.get(idRestaurant-1).getName(), 
                            Restaurant.restaurants.get(idRestaurant-1).getAddress(), 
                            Restaurant.restaurants.get(idRestaurant-1).getFoods().get(idMenu-1).get(0), 
                            Restaurant.restaurants.get(idRestaurant-1).getFoods().get(idMenu-1).get(1), 
                            totalOrder, 
                            distance
                            ));
                    }
                    break;
                case 2:
                    System.out.printf("%n%s - %s %nMenu Minuman: %n",Restaurant.restaurants.get(idRestaurant - 1).getName(),Restaurant.restaurants.get(idRestaurant - 1).getAddress());
                    if(drinks.size() == 0){
                        System.out.println("tidak ada minuman");
                    }else{
                        int idDrink = 1;
                        for(ArrayList<String> drink : Restaurant.restaurants.get(idRestaurant-1).getDrinks()){
                            System.out.printf("%d. %s\tRp. %s\n", idDrink, drink.get(0),drink.get(1));
                            idDrink++;
                        }
                        int idMenu, totalOrder=0;
                        System.out.println("Masukan id menu yang akan dipesan");
                        do{
                            idMenu = App.validInt();
                            if(idMenu<1 || idMenu >Restaurant.drinks.size()){
                                System.out.println("Input salah,coba ulangi\n=> ");
                            }
                        }while(idMenu<1 || idMenu >Restaurant.drinks.size());

                        System.out.println("jumlah pesanan");
                        do{
                            totalOrder = App.validInt();
                            if(totalOrder == 0){
                                System.out.println("masukan jumlah dengan benar!\n");
                            }
                        }while(totalOrder == 0);
                        System.out.println("masukan jarak: ");
                        double distance = App.validDouble();
                        Order.addOrder(new Order(
                            idRestaurant,                            
                            idMenu, 
                            Restaurant.restaurants.get(idRestaurant-1).getName(), 
                            Restaurant.restaurants.get(idRestaurant-1).getAddress(), 
                            Restaurant.restaurants.get(idRestaurant-1).getDrinks().get(idMenu-1).get(0), 
                            Restaurant.restaurants.get(idRestaurant-1).getDrinks().get(idMenu-1).get(1), 
                            totalOrder, 
                            distance
                            ));
                    }
                    break;
                default:
                    System.out.println("Input salah, Ulang");
                    break;
            }
        }
        else{
            System.out.println("Silahkan menambah restoran terlebih dahulu");
            return;
        }
    }
}
