import java.util.ArrayList;

public class Order {
    private String name,address, menuName, menuPrice;
    private int totalOrder;
    private static int idRestaurant, idMenu;
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

    public static int getidRestaurant(){
        return idRestaurant;
    }

    public static int getidMenu(){
        return idMenu;
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
        return Double.parseDouble(menuPrice) * totalOrder + ((distance % 10) * 1000);
    }

    // public class addOrder {
    // }

    public static double showOrder(){
        double totalPrice = 0.0;
        if(orders.size() == 0){
            System.out.println("Tidak ada orderan");
            return 0.0;
        }
        for(Order order: orders){
            System.out.printf("\nID RESTO :%d\nID MENU :%d\n%s-%s\t : %s\t\tRp. %s %dpcs \t\t : Rp. %.2f\n",
                getidRestaurant(),
                getidMenu(),
                order.getName(),
                order.getAddress(),
                order.getMenuName(),
                order.getMenuPrice(),
                order.getTotalOrder(),
                order.getTotalPrice());
                totalPrice = order.getTotalPrice();
        }
        return totalPrice;

    }
}  
