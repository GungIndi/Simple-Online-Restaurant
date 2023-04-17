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
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("\n\t==============================================");
            System.out.println("\t||             Welcome Customer!            ||");
            System.out.println("\t==============================================");
            System.out.println("\t==============================================");
            System.out.println("\t1. Buat Pesanan\n\t2. Lihat Pesanan\n\t3. Kembali ke login");
            System.out.println("\t==============================================");
            System.out.print("\tPilih Menu: ");
            int menu = App.validInt();
            switch(menu){
                case 1:
                    addOrder();
                    System.out.print("\tPress enter to continue...\n\t");
                    scan.nextLine();
                    App.clearScreen();
                    break;
                case 2:
                    Order.showOrder();
                    App.clearScreen();
                    break;
                case 3:
                    App.login();
                    return;
                default:
                    App.clearScreen();
                    System.out.println("\tInput salah, Ulang");
                    break;
            }
        }while(true);
    }

    public static void addOrder(){
        if(Restaurant.showRestaurant() != 0){
            int idRestaurant;
            do{ 
                // App.clearScreen(); 
                System.out.println("\n\t=============================================="); 
                System.out.print("\tPilih restoran yang ingin dipesan: ");
                idRestaurant = App.validInt();
                if(idRestaurant<1 || idRestaurant >Restaurant.restaurants.size()){
                    App.clearScreen();
                    System.out.println("\tInput salah,coba ulangi=> ");
                }
            }while(idRestaurant<1 || idRestaurant >Restaurant.restaurants.size());
            
            ArrayList<ArrayList<String>> foods = new ArrayList<>();
            ArrayList<ArrayList<String>> drinks = new ArrayList<>();
            foods = Restaurant.restaurants.get(idRestaurant - 1).getFoods();
            drinks = Restaurant.restaurants.get(idRestaurant - 1).getDrinks();
            int pesan;
            do{
                App.clearScreen();
                System.out.println("\n\t==============================================");
                System.out.println("\tMasukan jenis menu yang akan dipesan\n\t1. Makanan\n\t2. Minuman");
                int jenisMenu = App.validInt();
                switch(jenisMenu){
                    case 1:
                        App.clearScreen();
                        System.out.println("\n\t==============================================");
                        System.out.printf("\tRestoran %s - %s",Restaurant.restaurants.get(idRestaurant - 1).getName(),Restaurant.restaurants.get(idRestaurant - 1).getAddress());
                        System.out.println("\n\t==============================================");
                        if(foods.size() == 0){
                            App.clearScreen();
                            System.out.println("\n\t==============================================");
                            System.out.println("\tTidak ada makanan");
                        }else{
                            int idFood = 1;
                            for(ArrayList<String> food : Restaurant.restaurants.get(idRestaurant-1).getFoods()){
                                System.out.printf("\t%d. %s\tRp. %s\n", idFood, food.get(0),food.get(1));
                                idFood++;
                            }
                            int idMenu, totalOrder=0;
                            System.out.println("\tMasukan ID menu yang akan dipesan");
                            do{
                                idMenu = App.validInt();
                                if(idMenu<1 || idMenu >Restaurant.foods.size()){
                                    System.out.println("\tInput salah,coba ulangi => ");
                                }
                            }while(idMenu<1 || idMenu >Restaurant.foods.size());

                            System.out.println("\tJumlah Pesanan");
                            do{
                                totalOrder = App.validInt();
                                if(totalOrder == 0){
                                    System.out.println("\tMasukan jumlah dengan benar!\n");
                                }
                            }while(totalOrder == 0);
                            // System.out.println(("\tApakah ingin memesan menu lain?"));
                            System.out.print("\tMasukan jarak(KM): ");
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
                            System.out.println("\tPesanan Berhasil dibuat\n");
                        }
                        break;
                    case 2:
                        App.clearScreen();
                        System.out.println("\n\t==============================================");
                        System.out.printf("\tRestoran %s - %s",Restaurant.restaurants.get(idRestaurant - 1).getName(),Restaurant.restaurants.get(idRestaurant - 1).getAddress());
                        System.out.println("\n\t==============================================");
                        if(drinks.size() == 0){
                            System.out.println("\tTidak ada minuman");
                        }else{
                            int idDrink = 1;
                            for(ArrayList<String> drink : Restaurant.restaurants.get(idRestaurant-1).getDrinks()){
                                System.out.printf("\t%d. %s\tRp. %s\n", idDrink, drink.get(0),drink.get(1));
                                idDrink++;
                            }
                            int idMenu, totalOrder=0;
                            System.out.println("\tMasukan id menu yang akan dipesan");
                            do{
                                idMenu = App.validInt();
                                if(idMenu<1 || idMenu >Restaurant.drinks.size()){
                                    System.out.println("\tInput salah,coba ulangi =>");
                                }
                            }while(idMenu<1 || idMenu >Restaurant.drinks.size());

                            System.out.println("\tJumlah pesanan");
                            do{
                                totalOrder = App.validInt();
                                if(totalOrder == 0){
                                    System.out.println("\tMasukan jumlah dengan benar!\n");
                                }
                            }while(totalOrder == 0);
                            System.out.print("\tMasukan jarak(KM): ");
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
                        System.out.println("\tInput salah, Ulang");
                        break;
                }
                App.clearScreen();
                System.out.println("\n\t==============================================");
                System.out.println("\tApakah anda ingin memesan lagi?\n\t1. Ya\n\t2. Tidak");
                pesan = App.validInt();
                if(pesan<1 || pesan >2){
                    App.clearScreen();
                    System.out.println("\tInput salah,coba ulangi ");
                } else {
                    pesan = 0;
                }
                
            }while(pesan != 0);
        }
        else{
            System.out.println("\tSilahkan menambah restoran terlebih dahulu!\n");
            return;
        }
    }
}
