import java.util.*;
public class Restaurant {
    private String name, address;
    static ArrayList<Restaurant> restaurants = new ArrayList<>();
    private ArrayList<ArrayList<String>> foods = new ArrayList<>();
    private ArrayList<ArrayList<String>> drinks = new ArrayList<>();

    public Restaurant(String name, String address){
        this.name = name;
        this.address = address;
    }

    public static void addRestaurant(Restaurant restaurant){
        restaurants.add(restaurant);
    }

    public  void setName(String name){
        this.name = name;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public ArrayList<ArrayList<String>> getFoods() {
        return this.foods;
    }

    public ArrayList<ArrayList<String>> getDrinks() {
        return this.drinks;
    }

    public void addFood(String name, String price) {
        ArrayList<String> food = new ArrayList<String>();
        food.add(name);
        food.add(price);
        this.foods.add(food);
    }

    public void addDrink(String name, String price) {
        ArrayList<String> drink = new ArrayList<String>();
        drink.add(name);
        drink.add(price);
        this.drinks.add(drink);
    }

    public static int showRestaurant(){
        try{
            restaurants.get(0);
            System.out.println("All restaurants:");
            int i=1;
            for (Restaurant restaurant : restaurants) {
                System.out.printf("%d. %s%n",i,restaurant.getName());
                i++;
            }
            return 1;
        }catch(IndexOutOfBoundsException e){
            System.out.println("Restoran tidak ada");
            // System.out.println(restaurants.size());
            return 0;
        }
    }

    public static void removeRestaurant(int id){
        restaurants.remove(id-1);
    }

    public static void showMenu(){
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
            
            System.out.printf("%n%s - %s %nMenu Makanan: %n",Restaurant.restaurants.get(idRestaurant - 1).getName(),Restaurant.restaurants.get(idRestaurant - 1).getAddress());
            if(foods.size() == 0){
                System.out.println("tidak ada makanan");
            }else{
                int idFood = 1;
                for(ArrayList<String> food : Restaurant.restaurants.get(idRestaurant-1).getFoods()){
                    System.out.printf("%d. %s\tRp. %s\n", idFood, food.get(0),food.get(1));
                    idFood++;
                }
            }
            
            System.out.printf("Menu Minuman: %n");
            if(drinks.size() == 0){
                System.out.println("-Tidak ada minuman-");
            }else{
                int idDrink = 1;
                for(ArrayList<String> drink : Restaurant.restaurants.get(idRestaurant-1).getDrinks()){
                    System.out.printf("%d. %s\tRp. %s\n", idDrink, drink.get(0),drink.get(1));
                    idDrink++;
                }
            }
        }
        else{
            System.out.println("Silahkan menambah restoran terlebih dahulu");
            return;
        }
    }
}
