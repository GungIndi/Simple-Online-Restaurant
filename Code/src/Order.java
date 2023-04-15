import java.util.ArrayList;

public class Order {
    private String name,address, menuName, menuPrice;
    private int totalOrder, idRestaurant, idMenu;
    private double distance;
    private static ArrayList<Order> orders = new ArrayList<>();  
      
    public Order(int idRestaurant, int idMenu, String name, String address, String menuName, String menuPrice, int totalOrder, double distance){
        this.idRestaurant = idRestaurant;
        this.idMenu = idMenu;
        this.name = name;
        this.address = address;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.totalOrder = totalOrder;
        this.distance = distance;
    }

    public static void addOrder(Order order) {
        orders.add(order);
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getMenuName(){
        return menuName;
    }

    public String getMenuPrice(){
        return menuPrice;
    }

    public double getDistance(){
        return distance;
    }

    public int getTotalOrder(){
        return totalOrder;
    }

    public double getTotalPrice(){
        return Double.parseDouble(menuName) * totalOrder + ((distance % 10) * 1000);
    }

    public class addOrder {
    }
}  
