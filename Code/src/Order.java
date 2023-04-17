import java.util.ArrayList;
import java.util.Scanner;

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
        return Double.parseDouble(menuPrice) * totalOrder + ((distance % 1) * 1000);
    }

    public static double showOrder(){
        Scanner scan = new Scanner(System.in);
        App.clearScreen();
        double totalPrice = 0.0;
        if(orders.size() == 0){
            App.clearScreen();
            System.out.println("\n\t==============================================");
            System.out.println("\tTidak ada orderan");
            return 0.0;
        }
        for(Order order: orders){
            App.clearScreen();
            System.out.println("\n\t==============================================");
            System.out.printf("\n\tRestoran %s-%s\n\n\tID Resto : %d\n\tID Menu  : %d\n\t%s\tRp. %s\t %d pcs\n\tTotal : Rp. %.2f\n",
                order.getName(),
                order.getAddress(),
                getidRestaurant(),
                getidMenu(),
                order.getMenuName(),
                order.getMenuPrice(),
                order.getTotalOrder(),
                order.getTotalPrice());
                totalPrice = order.getTotalPrice();
                System.out.println("\n\t==============================================");
                System.out.print("\tPress enter to continue...");
                scan.nextLine();
        }
        return totalPrice;
    }
}  
