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

    public static void showRestaurant(){
        try{
            restaurants.get(0);
            System.out.println("All restaurants:");
            int i=1;
            for (Restaurant restaurant : restaurants) {
                System.out.printf("%d. %s%n",i,restaurant.getName());
                i++;
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("Restoran tidak ada");
            System.out.println(restaurants.size());
        }
    }

    public static void removeRestaurant(int id){
        restaurants.remove(id-1);
    }
}
