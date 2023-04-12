public class Restaurant {
    String name, address, menu;
    public Restaurant(String name, String address, String menu){
        this.name = name;
        this.address = address;
        this.menu = menu;
    }
    public  void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setMenu(String menu){
        this.address = menu;
    }
    
    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public String getMenu(){
        return this.menu;
    }

}
