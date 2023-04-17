import java.util.*;
public class Restaurant {
    private String name, address;
    static ArrayList<Restaurant> restaurants = new ArrayList<>();
    static ArrayList<ArrayList<String>> foods = new ArrayList<>();
    static ArrayList<ArrayList<String>> drinks = new ArrayList<>();

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

    public static ArrayList<ArrayList<String>> getFoods() {
        return foods;
    }

    public static ArrayList<ArrayList<String>> getDrinks() {
        return drinks;
    }

    public void addFood(String name, String price) {
        ArrayList<String> food = new ArrayList<String>();
        food.add(name);
        food.add(price);
        foods.add(food);
    }

    public void addDrink(String name, String price) {
        ArrayList<String> drink = new ArrayList<String>();
        drink.add(name);
        drink.add(price);
        drinks.add(drink);
    }

    public static int showRestaurant(){
        App.clearScreen();
        try{
            restaurants.get(0);
            System.out.println("\n\t==============================================");
            System.out.println("\tDaftar Restaurants:");
            int i=1;
            for (Restaurant restaurant : restaurants) {
                System.out.printf("\t%d. Restoran %s%n",i,restaurant.getName());
                i++;
            }
            return 1;
        }catch(IndexOutOfBoundsException e){
            App.clearScreen();
            System.out.println("\n\t==============================================");
            System.out.println("\tRestoran tidak ada!\n");
            // System.out.println(restaurants.size());
            return 0;
        }
    }

    public static void removeRestaurant(int id){
        restaurants.remove(id-1);
    }
}
