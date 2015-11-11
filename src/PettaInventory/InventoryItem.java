/*
 * 
 * 
 */
package PettaInventory;

/**
 *
 * @author MasterPaulo
 */
public class InventoryItem {
    private int code = 0;
    private int number;
    private String name;
    private String type = "OTHERS";
    private String image = "none";
    private double price;
    private int stock;
    private int quantity;
    
    //Constant object types
    private static final String[] types = {"CPU", "RAM","HDD","MAINBOARD",
                                           "GCARD","ROM","MODEM","LANCARD",
                                           "CASE","KEYBOARD","MOUSE","SPEAKERS",
                                           "MONITOR","PRINTER","SCANNER","OTHERS"};
    
    public InventoryItem(){
        quantity=0;
    }
    public InventoryItem(String[] args){
        code = Integer.parseInt(args[0]);
        type = types[code];
        name = args[1].replace('_', ' ');
        image = args[2];
        price = Double.parseDouble(args[3]);
        stock = Integer.parseInt(args[4]);
        quantity = Integer.parseInt(args[5]);
    }
    
    public void setItemCode(int code){
        this.code = code;
        this.type= types[code];
    }
    public void setItemNumber(int number){
        this.number = number;
    }
    public void setItemName(String name){
        this.name = name;
    }
    public void setItemType(String type){
        this.type = type;
    }
    public void setItemImage(String image){
        this.image = image;
    }
    public void setItemPrice(double price){
        this.price = price;
    }
    public void setItemStock(int stock){
        this.stock = stock;
    }
    public void setItemQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public int getItemCode(){
        return code;
    }
    public int getItemNumber(){
        return number;
    }
    public String getItemName(){
        return name;
    }
    public String getItemType(){
        return type;
    }
    public String getItemImage(){
        return image;
    }
    public double getItemPrice(){
        return price;
    }
    public int getItemStock(){
        return stock;
    }
    public int getItemQuantity(){
        return quantity;
    }
}
