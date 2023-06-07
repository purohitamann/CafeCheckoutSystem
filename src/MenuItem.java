/*Name: Aman Purohit -991669656
Purpose: Java Project: Cafe Checkout System
Created on: 04/10/2023
*/
public class MenuItem {

    private String itemName;
    private double itemPrice;
    private static int itemQunatity = 0;
    private boolean itemIsHot;

    public MenuItem() {

    }

    public MenuItem(String itemName, double itemsellPrice) {
        this.itemName = itemName;
        this.itemPrice = itemsellPrice;
    }

    public MenuItem(String itemName, Double itemPrice, int itemInStock, Boolean itemIsHot) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQunatity = itemInStock;
        this.itemIsHot = itemIsHot;

    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQunatity;
    }

    public void setItemQuantity(int itemInStock) {
        this.itemQunatity = itemInStock;
    }

    public void addQuantity() {
        this.itemQunatity++;
    }

    public boolean isItemIsHot() {
        return itemIsHot;
    }

    public void setItemIsHot(boolean itemIsHot) {
        this.itemIsHot = itemIsHot;
    }

}
