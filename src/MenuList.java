/*Name: Aman Purohit -991669656
Purpose: Java Project: Cafe Checkout System
Created on: 04/10/2023
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;
import javafx.scene.control.Menu;

public class MenuList extends MenuItem {

    ArrayList<MenuItem> listOfItem = new ArrayList<>();
    private static int orderNo = 0;
    private double subtotal = 0;

    private double total = 0;
    File receipt;

    LocalDateTime orderDate;
    String orderTime;
    login login;
     
    
  
  
    public MenuList() {
        this.subtotal = generateSubtotal();
        this.orderNo++;
        

    }

    public File getReceipt() {
        return receipt;
    }

    public void setReceipt(File receipt) {
        this.receipt = receipt;
    }

    public int size() {
        return listOfItem.size();
    }

    public void add(Object object) {
        listOfItem.add((MenuItem) object);

    }

    public MenuItem get(int i) {
        return listOfItem.get(i);
    }

    public int getItemCount() {
        return listOfItem.size();
    }

    public void remove(MenuItem item) {
        listOfItem.remove(item);
    }

    public void clear() {
        listOfItem.clear();
        this.orderNo++;
    }

    public static int getOrderNo() {
        return orderNo;
    }

    public static void setOrderNo(int orderNo) {
        MenuList.orderNo = orderNo;
    }

    public ArrayList<MenuItem> getListOfItem() {
        return listOfItem;
    }

    public void setListOfItem(ArrayList<MenuItem> listOfItem) {
        this.listOfItem = listOfItem;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setTotal(double total) {
        this.total = total;
    }
   

    public double generateSubtotal() {
        double subtotal = 0.00;
        for (int i = 0; i < listOfItem.size(); i++) {
            subtotal = subtotal + Math.round(listOfItem.get(i).getItemPrice() * 100) / 100.00;

        }
        return Math.round(subtotal * 100) / 100.00;
    }

    public double getTotal() {

        double total = generateSubtotal() * 1.13;

        return Math.round(total * 100) / 100.00;
    }

    public boolean empty() {
        return listOfItem.isEmpty();
    }

    public void generateReceipt() throws IOException {
        
        
        Random random = new Random();
        int orderID = random.nextInt(MenuList.orderNo * 100);
        this.orderDate = LocalDateTime.now();
        this.orderTime = this.orderDate.getHour()+"";
        this.orderTime+= ":"+ String.format("%02d", this.orderDate.getMinute());
       
        File receipt = new File("src\\receipts\\" + this.orderNo + ".txt");
        PrintWriter writer = new PrintWriter(receipt);
        writer.println("Order No: " + this.orderNo);
        writer.println("Order Id: " + orderID);
        writer.println("Order Date: " + this.orderDate.getMonthValue()+"/"+this.orderDate.getDayOfMonth()+"/"+this.orderDate.getYear());
        writer.println("Order Time: " + this.orderTime);
         for (int i = 0; i < listOfItem.size(); i++) {
            writer.printf("%-10s %-4.2f\n", listOfItem.get(i).getItemName(), listOfItem.get(i).getItemPrice());

        }
        writer.println("Item Count: " + getItemCount());
        writer.println("Subtotal: " + generateSubtotal());
        writer.println("Taxable Total: " + getTotal());
        writer.println("Your Cashier today "+ LoginFx.currentUser.getEmployeeFristName());
        writer.println("\n---------Thank You--------");
        writer.close();

    }

    public void generateReceiptraf() throws IOException {

        ObjectOutputStream rafReceipt = new ObjectOutputStream(
                new FileOutputStream("src\\rafReceipts\\" + this.orderNo));

        rafReceipt.writeByte(orderNo);

        for (int i = 0; i < listOfItem.size(); i++) {

            String originalString = String.format("%10s %4.2f ", listOfItem.get(i).getItemName(),
                    listOfItem.get(i).getItemPrice());
            String paddedString = String.format("%1$-10s", originalString);
            rafReceipt.writeUTF(paddedString);
        }
        rafReceipt.write(getItemCount());
        rafReceipt.writeDouble(generateSubtotal());
        rafReceipt.writeDouble(getTotal());
        rafReceipt.close();

    }

    public String getorderdetail(int orderNo) throws FileNotFoundException, IOException {

        StringBuilder sb = new StringBuilder();
        File receipt = new File("src\\receipts\\" + orderNo + ".txt");
        Scanner scan = new Scanner(receipt);
        while (scan.hasNext()) {
            sb.append(scan.nextLine() + "\n");
        }
        return sb.toString();

    }

    public String printList() {
        String list = " ";
        for (int i = 0; i < listOfItem.size(); i++) {
            list += listOfItem.get(i).getItemName();

        }
        return list;
    }

}
